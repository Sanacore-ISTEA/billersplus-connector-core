package com.wu.billersplus.service.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.powermock.api.mockito.PowerMockito.when;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wu.billersplus.connector.entities.ConnectorEchoRequest;
import com.wu.billersplus.connector.entities.ConnectorRequest;
import com.wu.billersplus.connector.entities.ConnectorResponse;
import com.wu.billersplus.connector.exceptions.ConectorException;
import com.wu.billersplus.entities.BillersPlusDeuda;
import com.wu.billersplus.entities.BillersPlusRequest;
import com.wu.billersplus.entities.ConsultaDeudaRequest;
import com.wu.billersplus.entities.ConsultaDeudaResponse;
import com.wu.billersplus.entities.PagoResponse;
import com.wu.billersplus.framework.configuration.PropertyHandler;
import com.wu.billersplus.framework.connector.service.ConnectorService;
import com.wu.billersplus.framework.entities.BillerResponseWrapper;
import com.wu.billersplus.framework.service.EchoService;
import com.wu.billersplus.framework.service.ProxyHelperService;
import com.wu.billersplus.framework.service.ProxyService;
import com.wu.billersplus.framework.service.impl.ActualizarConectorServiceImpl;
import com.wu.billersplus.framework.service.impl.BillerPlusFacadeImpl;
import com.wu.billersplus.framework.service.impl.ConectorServiceFacade;
import com.wu.billersplus.framework.service.impl.EchoServiceAbstract;
import com.wu.billersplus.framework.service.impl.ParametrosConectorServiceImpl;

import com.wu.billersplus.connector.entities.DeudaParameters;
import com.wu.billersplus.connector.transformers.BillerTransformer;
import com.wu.billersplus.service.mock.ConnectorServiceMockOffline;

import ar.com.sepsa.commons.model.biller.Biller;
import ar.com.sepsa.commons.model.biller.Connector;
import ar.com.sepsa.commons.model.biller.ConnectorParameter;
import ar.com.sepsa.sei.biller.BillerService;

public class ServiceTest {

	Logger logger = LoggerFactory.getLogger(getClass());

	ProxyService proxyClient;
	ProxyHelperService proxyHelper;
	ConnectorService cService;
	BillerService billerService;
	BillerPlusFacadeImpl orquestadorservice;
	ParametrosConectorServiceImpl ppHelper;
	ActualizarConectorServiceImpl actualizarConectorService;
	ConectorServiceFacade serviceFacade;
	EchoService echoService;

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		proxyClient = Mockito.mock(ProxyService.class);
		proxyHelper = Mockito.mock(ProxyHelperService.class);
		echoService = Mockito.mock(EchoService.class);
		cService = new ConnectorServiceMockOffline();

		// MOCKEO DE BILLER
		billerService = Mockito.mock(BillerService.class);
		Mockito.when(billerService.getConnectorInstance(Mockito.anyLong())).thenReturn(this.getConnector());
		Mockito.when(billerService.getBiller(Mockito.anyLong(), Mockito.anyString(), Mockito.anyString(),
				Mockito.anyString())).thenReturn(this.getBiller());

		when(proxyHelper.getProxyByProductoUtilityCode(Mockito.anyString())).thenReturn(proxyClient);
		try {
			// ESTOS SERVICIOS SON LOS DE LA INVOCACION AL CONECTOR. IMPLEMENTAR
			// EL FACTORY
			when(proxyClient.consulta(any())).thenAnswer(new Answer<BillerResponseWrapper>() {

				@Override
				public BillerResponseWrapper answer(InvocationOnMock invocation) throws Throwable {
					Thread.sleep(1000l);
					return getResponseFactory("consulta");
				}
			});
			when(proxyClient.directa(any())).thenReturn(getResponseFactory("directa"));
			when(proxyClient.reversa(any())).thenReturn(getResponseFactory("reversa"));
			when(proxyClient.consultaEstado(any())).thenReturn(getResponseFactory("directa"));
		} catch (ConectorException e) {
			logger.error("Error en la invocacion del cliente");
			throw e;
		}

		ppHelper = new ParametrosConectorServiceImpl(billerService);
		ppHelper.init();

		BillerTransformer bTransformer = new BillerTransformer();
		actualizarConectorService = new ActualizarConectorServiceImpl(cService, ppHelper, proxyHelper, billerService);
		actualizarConectorService.init();

		orquestadorservice = new BillerPlusFacadeImpl(proxyHelper, bTransformer, actualizarConectorService, null,
				echoService);

		serviceFacade = new ConectorServiceFacade(orquestadorservice);

	}

	private Biller getBiller() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String billerJson = "{  \"billerId\": 21989354,  \"companyId\": 21989353,  \"utilityCode\": \"46150001\",  \"tolerance\": {    \"billerId\": 0,    \"maxErrorLines\": 21989354  },  \"statistics\": null,  \"actualStatistic\": null,  \"billerInformation\": {    \"barCodeFunction\": {      \"content\": \"def static barCodeFunction(entrada){return entrada.numeroDeSecuencia + 1234513;}\"    },    \"mapping\": [      {        \"option\": \"HEADER\",        \"content\": \"salida.accion = entrada.accion == \\\"A\\\" ? Accion.AGREGA : Accion.REEMPLAZA;\"      },      {        \"option\": \"BODY\",        \"content\": \"salida.deudaBus1n = entrada.idPrimario.toDouble();\\nsalida.deudaBus1c = entrada.idSecundario;\\nsalida.deudaBus2c = entrada.idPrimario.toLong();\\nsalida.deudaDato1 = entrada.nombreCliente;\\nsalida.deudaDato2 = entrada.codigoDeBarras.substring(16, 16+15).toLong();\\nsalida.deudaDato3 = entrada.numeroDeSecuencia;\\nsalida.deudaMsg1 = entrada.mensaje;\\nsalida.codigoDeBarras = entrada.codigoDeBarras + \\\"O\\\";\\nsalida.deudaImp1 = 8000;\\nsalida.deudaVenc1 = fechaJuliano(entrada.codigoDeBarras.substring(11, 11+5));\\nsalida.fechaVigencia = entrada.fechaVigencia;\\nsalida.fechaVencimiento = entrada.fechaVencimiento;\\nsalida.tipoDePago = TipoDePago(entrada.tipoDePago);\\nsalida.monedaCod = TipoDeMonedaArg(entrada.tipoMoneda);\\nsalida.deudaTicket = entrada.mensaje;\"      }    ],    \"grammar\": {      \"type\": \"FIXED_SIZE\",      \"content\": \"header{\\ntipoDeRegistro:2:String;\\ncantidadDeRegistros:9:Integer;\\naccion:1:String;\\nutility:8:String;\\nfecha:8:Date:yyyyMMdd;\\nfiller:172:String;\\n}\\nbody{\\ntipoDeRegistro:2:String;\\nidPrimario:21:Integer;\\nidSecundario:30:String;\\nnumeroDeSecuencia:6:Integer;\\nmensaje:20:String;\\nnombreCliente:40:String;\\ncodigoDeBarras:55:String;\\nfechaVigencia:8:Date:yyyyMMdd;\\nfechaVencimiento:8:Date:yyyyMMdd;\\ntipoDePago:1:String;\\nfiller:9:String;\\n}\",      \"lineWidth\": 200,      \"headerPrefix\": \"01\",      \"bodyPrefix\": \"02\",      \"footerPrefix\": \"03\",      \"prefixLength\": 0,      \"separator\": \"\\u0000\"    },    \"headerId\": \"46150001\",    \"validator\": null,    \"fileLoad\": null,    \"folder\": \"46150001\",    \"order\": \"ASCENDENTE\",    \"orderField\": \"ID_PRODUCTO\",    \"fileTypeCode\": \"TEXT_PLAIN\",    \"orderBy\": [      {        \"order\": \"ASCENDENTE\",        \"orderField\": \"ID_PRODUCTO\"      },      {        \"order\": \"DESCENDENTE\",        \"orderField\": \"DEUDA_IMP_1\"      }    ],    \"maxDeudaRegistries\": 10,    \"qryType\": \"ON_LINE\"  },  \"labels\": null,  \"productoMarcaDeuda\": true,  \"batchDefaultAction\": null,  \"filePostProcesorJarName\": null,  \"countryCode\": \"AR\",  \"password\": null,  \"frontEndResponse\": \"N\",  \"timeZone\": \"GMT-3\"}";
		Biller biller = mapper.readValue(billerJson, Biller.class);
		return biller;
	}

	@Test
	@org.junit.Ignore
	public void testConsultaService() {

		logger.info("Iniciando test de inicialización de servicio");

		ConsultaDeudaRequest request = new ConsultaDeudaRequest();
		request.setIdTerminal("X00202");
		request.setIdTransaccionFe(333444L);
		request.setFechaHoraFe(DateTime.now());
		request.setPlataforma("S");
		request.setCodigoPais("AR");
		request.setIdOperador("000020");
		request.setIdCaja("B-SS-DES");
		request.setProductoUtilityCode("00250001");
		request.setDeudaBus1n(12345);

		ConnectorResponse<ConsultaDeudaResponse> deudaResponse = serviceFacade.consulta(request);

		assertNotNull("El wrapper es nula", deudaResponse);
		assertNotNull("La respuesta es nula", deudaResponse.getResponse());
		assertNotNull("El response al biller es nulo", deudaResponse.getResponseOriginalBiller());
		assertNotNull("El request al biller es nula", deudaResponse.getRequestOriginalBiller());
		assertTrue("El codigo de respuesta es incorrecto", deudaResponse.getResponse().getCodigoError() == 1);

	}

	@Test
	@org.junit.Ignore
	public void testDirectaService() {

		logger.info("Iniciando test de inicialización de servicio");

		ConnectorResponse<PagoResponse> deudaResponse = serviceFacade.directa(getConnectorRequest());

		assertNotNull("El wrapper es nula", deudaResponse);
		assertNotNull("La respuesta es nula", deudaResponse.getResponse());
		assertTrue("El codigo de producto es incorrecto",
				deudaResponse.getResponse().getProductoUtilityCode().equals("Biller_1234"));
		assertNotNull("El response al biller es nulo", deudaResponse.getResponseOriginalBiller());
		assertNotNull("El request al biller es nula", deudaResponse.getRequestOriginalBiller());
		assertTrue("El codigo de respuesta es incorrecto", deudaResponse.getResponse().getCodigoError() == 1);

	}

	@Test
	@org.junit.Ignore
	public void testConsultaEstadoService() {

		logger.info("Iniciando test de inicialización de servicio");

		ConnectorResponse<PagoResponse> deudaResponse = serviceFacade.consultaEstado(getConnectorRequest());

		assertNotNull("El wrapper es nula", deudaResponse);
		assertNotNull("La respuesta es nula", deudaResponse.getResponse());
		assertTrue("El codigo de producto es incorrecto",
				deudaResponse.getResponse().getProductoUtilityCode().equals("Biller_1234"));
		assertNotNull("El response al biller es nulo", deudaResponse.getResponseOriginalBiller());
		assertNotNull("El request al biller es nula", deudaResponse.getRequestOriginalBiller());
		assertTrue("El codigo de respuesta es incorrecto", deudaResponse.getResponse().getCodigoError() == 1);

	}

	@Test
	@org.junit.Ignore
	public void testAnulacionService() {

		logger.info("Iniciando test de inicialización de servicio");

		ConnectorResponse<PagoResponse> deudaResponse = serviceFacade.reversa(getConnectorRequest());

		assertNotNull("El wrapper es nula", deudaResponse);
		assertNotNull("La respuesta es nula", deudaResponse.getResponse());
		assertTrue("El codigo de producto es incorrecto",
				deudaResponse.getResponse().getProductoUtilityCode().equals("Biller_1234"));
		assertNotNull("El response al biller es nulo", deudaResponse.getResponseOriginalBiller());
		assertNotNull("El request al biller es nula", deudaResponse.getRequestOriginalBiller());

	}
	
	@Test
	@org.junit.Ignore
	public void testEchoService() {

		logger.info("Iniciando test de inicialización de servicio");

		ConnectorEchoRequest connectorEchoRequest = new ConnectorEchoRequest();
		connectorEchoRequest.setCodigoProducto("00250001");
		connectorEchoRequest.setDato(null);
		
		Long result = serviceFacade.echo(connectorEchoRequest);

		logger.info("La operacion de echo tardó {}", result);
		if (result == EchoServiceAbstract.ERROR_CONFIGURACION || result == EchoServiceAbstract.ERROR_CRITICO
				|| result == EchoServiceAbstract.ERROR_NO_CRITICO) {
			fail("El servicio de echo retornó un mensaje de error");
		}

	}

	private Connector getConnector() {
		Connector connector = new Connector();
		connector.setBillerId(250001L);
		connector.setCode("111222");
		connector.setDescription("Una descripcion");
		connector.setName("Conector Offline");
		connector.setUrl(PropertyHandler.getPropertyString("client.url"));
		List<ConnectorParameter> connectorParameters = new ActualizarConectorServiceImpl()
				.obtenerParamametrosConector();
		connector.setParameters(connectorParameters);
		return connector;
	}

	private ConnectorRequest getConnectorRequest() {

		BillersPlusRequest request = new BillersPlusRequest();

		request.setIdTerminal("X00202");
		request.setFechaHoraFe(DateTime.now());
		request.setIdTransaccionFe(333444L);
		request.setPlataforma("S");
		request.setCodigoPais("AR");
		request.setIdOperador("000020");
		request.setIdCaja("B-SS-DES");
		request.setProductoUtilityCode("00250001");
		request.setConsultaSesion("123456789");
		request.setFechaHoraFe(DateTime.now());

		BillersPlusDeuda deuda = new BillersPlusDeuda();
		Map<String, String> parametrosDeuda = new HashMap<>();
		parametrosDeuda.put(DeudaParameters.DATO, "12345");
		deuda.setParametrosDeuda(parametrosDeuda);

		ConnectorRequest cRequest = new ConnectorRequest();
		cRequest.setDeuda(deuda);
		cRequest.setBillersPlusRequest(request);

		return cRequest;

	}

	@SuppressWarnings("rawtypes")
	private BillerResponseWrapper getResponseFactory(String criteria) {

		return null;
	}

}
