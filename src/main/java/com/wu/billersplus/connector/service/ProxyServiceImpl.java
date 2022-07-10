package com.wu.billersplus.connector.service;

import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wu.billersplus.connector.dto.ConsultaReqDTO;
import com.wu.billersplus.connector.dto.DirectaReqDTO;
import com.wu.billersplus.connector.dto.ReversaReqDTO;
import com.wu.billersplus.connector.entities.ParametrosConector;
import com.wu.billersplus.connector.exceptions.ConectorException;
import com.wu.billersplus.connector.exceptions.ProxyException;
import com.wu.billersplus.connector.utils.SOAPLoggingHandler;
import com.wu.billersplus.connector.ws.Consulta;
import com.wu.billersplus.connector.ws.ConsultaResp;
import com.wu.billersplus.connector.ws.Directa;
import com.wu.billersplus.connector.ws.DirectaResp;
import com.wu.billersplus.connector.ws.GenericoMethodsService;
import com.wu.billersplus.connector.ws.MethodsWS;
import com.wu.billersplus.connector.ws.Reversa;
import com.wu.billersplus.connector.ws.ReversaResp;
import com.wu.billersplus.framework.configuration.PropertyHelper;
import com.wu.billersplus.framework.entities.BillerResponseWrapper;
import com.wu.billersplus.framework.service.ProxyService;
import com.wu.billersplus.framework.service.impl.ProxyServiceAbstract;

public class ProxyServiceImpl extends ProxyServiceAbstract {

	private static Logger logger = LoggerFactory.getLogger(ProxyServiceImpl.class);

	private MethodsWS service;

	public ProxyServiceImpl() {
		super();
	}

	public BillerResponseWrapper<?> consulta(Object request) throws ConectorException {

		ConsultaReqDTO requestConsulta = (ConsultaReqDTO) request;
		Consulta consulta = requestConsulta.getConsulta();

		logConectorTraceRequest(consulta, consulta.getUtility());

		if (requestConsulta.getEndpoint() != null && !"".equals(requestConsulta.getEndpoint().trim()))
			((BindingProvider) this.service).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
					requestConsulta.getEndpoint().trim());

		ConsultaResp deudasPriorizadas = this.service.consulta(consulta.getHdReq(), consulta.getUtility(),
				consulta.getCodBarra(), consulta.getCodigoCliente());

		logConectorTraceResponse(deudasPriorizadas, consulta.getUtility());

		return new BillerResponseWrapper<ConsultaResp>(deudasPriorizadas, mapBillerTrace(request),
				mapBillerTrace(deudasPriorizadas));

	}

	public BillerResponseWrapper<?> directa(Object request) throws ConectorException {

		DirectaReqDTO directaReq = (DirectaReqDTO) request;
		Directa directa = directaReq.getDirecta();

		logConectorTraceRequest(directa, directa.getUtility());

		if (directaReq.getEndpoint() != null && !"".equals(directaReq.getEndpoint().trim()))
			((BindingProvider) this.service).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
					directaReq.getEndpoint().trim());

		DirectaResp directaResponse = this.service.directa(directa.getHdReq(), directa.getCheck(),
				directa.getUtility(), directa.getBarCode(), directa.getMedioPago(), directa.getCreditCard(),
				directa.getAmount());

		logConectorTraceResponse(directaResponse, directa.getUtility());

		return new BillerResponseWrapper<DirectaResp>(directaResponse, mapBillerTrace(request),
				mapBillerTrace(directaResponse));
	}

	public BillerResponseWrapper<?> reversa(Object request) throws ConectorException {

		ReversaReqDTO reversaReq = (ReversaReqDTO) request;
		Reversa reversa = reversaReq.getReversa();

		logConectorTraceResponse(reversa, reversa.getUtility());

		if (reversaReq.getEndpoint() != null && !"".equals(reversaReq.getEndpoint().trim()))
			((BindingProvider) this.service).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
					reversaReq.getEndpoint().trim());

		ReversaResp reversaResponse = this.service.reversa(reversa.getHdReq(), reversa.getTerminalOriginal(),
				reversa.getCajeroOriginal(), reversa.getFechaHoraOriginal(), reversa.getNroSecuenciaOriginal(),
				reversa.getTipoReversa(), reversa.getUtility(), reversa.getAmount());

		logConectorTraceResponse(reversaResponse, reversa.getUtility());

		return new BillerResponseWrapper<ReversaResp>(reversaResponse, mapBillerTrace(request),
				mapBillerTrace(reversaResponse));

	}

	public BillerResponseWrapper<?> consultaEstado(Object request) throws ConectorException {
		logger.warn("Operacion no implementada");
		// TODO implementar con su propia implementacion
		return null;
	}

	public ProxyService createClient(Map<String, String> arguments) throws ProxyException {

		try {
			if (arguments.get(ParametrosConector.PROXY_URL_PARAMETER) == null) {
				throw new ProxyException(null, ProxyException.URL_INEXISTENTE);
			}
			logger.info("createClient --> arguments [{}]", arguments);

			logger.info("[Conector Codigo {}] Instanciando proxy para el con URL {}",
					PropertyHelper.getConnectorCode(), arguments.get(ParametrosConector.PROXY_URL_PARAMETER));

			logger.info("prepareWebServiceConnection");
			this.prepareWebServiceConnection(true);
			logger.info("finaly prepareWebServiceConnection");

			String urlGet = arguments.get(ParametrosConector.PROXY_URL_WET_PARAMETER);
			URL url = null;

			if (urlGet == null || "".equals(urlGet)) {
				logger.info("No se definio url de descarga del descriptor. se utiliza la URL principal");
				url = new URL(arguments.get(ParametrosConector.PROXY_URL_PARAMETER));
			} else {
				logger.info("La url para levantar el descriptor es [{}]", urlGet);
				url = new URL(urlGet);
			}

			this.service = new GenericoMethodsService(url).getGenericoMethods();

			((BindingProvider) this.service).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
					arguments.get(ParametrosConector.PROXY_URL_PARAMETER));
			((BindingProvider) this.service).getRequestContext().put("javax.xml.ws.client.connectionTimeout",
					Integer.valueOf(arguments.get(ParametrosConector.PROXY_SOCKETTIMEOUT_PROPERTY)));
			((BindingProvider) this.service).getRequestContext().put("javax.xml.ws.client.receiveTimeout",
					Integer.valueOf(arguments.get(ParametrosConector.PROXY_TIMEOUT_PROPERTY)));

			@SuppressWarnings("rawtypes")
			java.util.List<Handler> handlers = ((BindingProvider) this.service).getBinding().getHandlerChain();
			handlers.add(new SOAPLoggingHandler());
			((BindingProvider) this.service).getBinding().setHandlerChain(handlers);

		} catch (Exception e) {
			logger.error("[Conector Codigo {}] Excepcion al crear el proxy", PropertyHelper.getConnectorCode());
			throw new RuntimeException(e);
		}

		return this;

	}

	/**
	 *
	 * @param trustAllCertificates
	 * @throws NoSuchAlgorithmException
	 * @throws KeyManagementException
	 */
	private void prepareWebServiceConnection(Boolean trustAllCertificates) throws NoSuchAlgorithmException,
			KeyManagementException {

		if (trustAllCertificates) {
			// Marco todos los certificados como validos
			this.disableSSL();

			// Deshabilito la validacion de CN para los certificados
			this.disableCNValidation();
		}
	}

	private void disableSSL() throws NoSuchAlgorithmException, KeyManagementException {
		// Create a trust manager that does not validate certificate chains
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkClientTrusted(X509Certificate[] certs, String authType) {
			}

			public void checkServerTrusted(X509Certificate[] certs, String authType) {
			}
		} };

		// Install the all-trusting trust manager
		SSLContext sc = SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, new java.security.SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

		// Create all-trusting host name verifier
		HostnameVerifier allHostsValid = new HostnameVerifier() {
			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		};
		logger.info("allHostsValid " + allHostsValid);
		// Install the all-trusting host verifier
		HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
	}

	private void disableCNValidation() {
		// Realizado con una property en el standalone-full.xml
	}

}
