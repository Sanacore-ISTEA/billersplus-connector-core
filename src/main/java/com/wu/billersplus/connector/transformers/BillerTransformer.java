package com.wu.billersplus.connector.transformers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wu.billersplus.connector.dto.ConsultaReqDTO;
import com.wu.billersplus.connector.dto.DirectaReqDTO;
import com.wu.billersplus.connector.dto.ReversaReqDTO;
import com.wu.billersplus.connector.entities.ConnectorRequest;
import com.wu.billersplus.connector.entities.ConnectorResponse;
import com.wu.billersplus.connector.entities.ParametrosConector;
import com.wu.billersplus.connector.utils.DateUtils;
import com.wu.billersplus.connector.utils.Decimal;
import com.wu.billersplus.connector.ws.ArrayFieldsQuerie;
import com.wu.billersplus.connector.ws.Check;
import com.wu.billersplus.connector.ws.Consulta;
import com.wu.billersplus.connector.ws.ConsultaResp;
import com.wu.billersplus.connector.ws.Directa;
import com.wu.billersplus.connector.ws.DirectaResp;
import com.wu.billersplus.connector.ws.HeaderReq;
import com.wu.billersplus.connector.ws.HeaderResp;
import com.wu.billersplus.connector.ws.Reversa;
import com.wu.billersplus.connector.ws.ReversaResp;
import com.wu.billersplus.entities.BillersPlusDeuda;
import com.wu.billersplus.entities.BillersPlusRequest;
import com.wu.billersplus.entities.ConsultaDeudaResponse;
import com.wu.billersplus.entities.PagoResponse;
import com.wu.billersplus.framework.cdi.qualifiers.BillerPlusServiceBean;
import com.wu.billersplus.framework.configuration.PropertyHelper;
import com.wu.billersplus.framework.entities.BillerResponseWrapper;
import com.wu.billersplus.framework.service.ParametrosConectorService;
import com.wu.billersplus.framework.transformer.BillerPlusTransformerService;

/**
 *
 * Se deberÃ¡n implementar aquÃ­ todas las transformaciones de datos necesarias desde las clases de 100Billers Plus a
 * sus respectivos requests para los billers
 *
 */
@Stateless
@BillerPlusServiceBean
public class BillerTransformer implements BillerPlusTransformerService {

	private static Logger logger = LoggerFactory.getLogger(BillerTransformer.class);

	@Inject
	@BillerPlusServiceBean
	private ParametrosConectorService parametrosConector;

	public Object getDeudaRequest(BillersPlusRequest billersPlusRequest) {

		logger.info("[Conector Codigo {}] Ejecutando CONSULTA con [CodigoProducto {}] [Version {}]",
				PropertyHelper.getConnectorCode(), billersPlusRequest.getProductoUtilityCode(),
				ParametrosConector.VERSION_PROPERTY);

		Consulta consulta = new Consulta();

		consulta.setUtility(billersPlusRequest.getProductoUtilityCode());
		consulta.setCodigoCliente(billersPlusRequest.getDeudaBus2c());
		consulta.setCodBarra(billersPlusRequest.getDeudaBus1c());

		consulta.setHdReq(this.getHeaderRequest(billersPlusRequest, ParametrosConector.ID_MENSAJE_CONSULTA_DIRECTA,
				ParametrosConector.COD_TRX_CONSULTA));

		ConsultaReqDTO request = new ConsultaReqDTO();
		request.setConsulta(consulta);
		Map<String, String> parametros = parametrosConector.getParametrosConectorPorBiller(billersPlusRequest
				.getProductoUtilityCode());
		request.setEndpoint(parametros.get(ParametrosConector.PROXY_ENDPOINT_CONSULTA));

		return request;
	}

	public ConnectorResponse<ConsultaDeudaResponse> getResponseForConsultaDeuda(ConsultaDeudaResponse response,
			BillerResponseWrapper<?> consultaResponse) {
		if (consultaResponse == null) {
			logger.warn("La respuesta de la directa es nula");
			return new ConnectorResponse<ConsultaDeudaResponse>(response, null, null, null);
		}

		if (consultaResponse.getResponseBiller() == null) {
			logger.warn("La respuesta wrappeada del biller es nula");
			return new ConnectorResponse<ConsultaDeudaResponse>(response, null,
					consultaResponse.getRequestBillerTrace(), consultaResponse.getResponseBillerTrace());
		}

		ConsultaResp datosRespuesta = (ConsultaResp) consultaResponse.getResponseBiller();
		HeaderResp headerRespuesta = datosRespuesta.getHeader();

		response.setDescripcionError(getDescripcionError(headerRespuesta.getCodError()));
		response.setCodigoError(headerRespuesta.getCodError());
		if (headerRespuesta.getCodError() == 0) {
			try {
				response.setIdOperador(headerRespuesta.getCajero());
				response.setIdTerminal(headerRespuesta.getTerminal());
				response.setFechaHoraFE(new DateTime());
				// response.setProdPriorizaDeuda(datosRespuesta.getSeleccionConPrioridad() != null
				// && datosRespuesta.getSeleccionConPrioridad() == 1);
				String nombre = datosRespuesta.getCobClienteNomb();

				List<ArrayFieldsQuerie> items = datosRespuesta.getFields().getItem();
				List<BillersPlusDeuda> deudas = new ArrayList<BillersPlusDeuda>();

				for (ArrayFieldsQuerie arrayFieldsQuerie : items) {
					if (ParametrosConector.ESTADO_DISPONIBLE.equals(arrayFieldsQuerie.getCobEstado())) {
						BillersPlusDeuda deuda = new BillersPlusDeuda();
						Map<String, String> parametros = parametrosConector.getParametrosConectorPorBiller(response
								.getProductoUtilityCode());
						String recargaConBarra = parametros.get(ParametrosConector.RECARGA_CON_BARRA) != null
								&& StringUtils.isNotEmpty(parametros.get(ParametrosConector.RECARGA_CON_BARRA).trim()) ? parametros
								.get(ParametrosConector.RECARGA_CON_BARRA).trim() : "";
						deuda.setCodigoBarra(arrayFieldsQuerie.getCobCodBarra() != null ? arrayFieldsQuerie
								.getCobCodBarra().concat(recargaConBarra) : "");

						BigDecimal importe = arrayFieldsQuerie.getCobCompImp() == null ? BigDecimal.ZERO
								: new BigDecimal(arrayFieldsQuerie.getCobCompImp());
						deuda.setDeudaImp1(importe.divide(new BigDecimal(100)));
						logger.info("IMPORTE " + deuda.getDeudaImp1());
						deuda.setDeudaMsg1(arrayFieldsQuerie.getCobTextoFe() != null ? arrayFieldsQuerie
								.getCobTextoFe() : "");
						deuda.setDeudaDato1(nombre);
						deuda.setTipoDePago(arrayFieldsQuerie.getCobCobroTipo());
						deuda.setDeudaDato2(String.valueOf(arrayFieldsQuerie.getNumeroDeOrden()));

						deudas.add(deuda);
					}

				}

				response.setDeudas(deudas);
			} catch (Exception e) {
				logger.error("Error al parsear la rta de la entidad. ", e);
				response.setCodigoError(99);
				response.setDescripcionError("Error al parsear la rta de la entidad. " + e.getMessage());
			}
		}

		logger.info("[Conector Codigo {}] Ejecutando CONSULTA con [CodigoProducto {}]",
				PropertyHelper.getConnectorCode(), response.getProductoUtilityCode());

		return new ConnectorResponse<ConsultaDeudaResponse>(response, null, consultaResponse.getRequestBillerTrace(),
				consultaResponse.getResponseBillerTrace());
	}

	public Object getDirectaRequest(ConnectorRequest connectorRequest) {

		logger.info("[Conector Codigo {}] Ejecutando DIRECTA con [CodigoProducto {}] [Version {}]",
				PropertyHelper.getConnectorCode(), connectorRequest.getBillersPlusRequest().getProductoUtilityCode(),
				ParametrosConector.VERSION_PROPERTY);

		Map<String, String> parametros = parametrosConector.getParametrosConectorPorBiller(connectorRequest
				.getBillersPlusRequest().getProductoUtilityCode());

		Directa directa = new Directa();
		directa.setHdReq(getHeaderRequest(connectorRequest.getBillersPlusRequest(),
				ParametrosConector.ID_MENSAJE_CONSULTA_DIRECTA, ParametrosConector.COD_TRX_DIRECTA_REVERSA));
		directa.setAmount(Integer.valueOf(Decimal.unformat(connectorRequest.getBillersPlusRequest().getImporte())));
		String recargaConBarra = parametros.get(ParametrosConector.RECARGA_CON_BARRA) != null
				&& StringUtils.isNotEmpty(parametros.get(ParametrosConector.RECARGA_CON_BARRA).trim()) ? parametros
				.get(ParametrosConector.RECARGA_CON_BARRA).trim() : "";
		String barra = connectorRequest.getBillersPlusRequest().getCodigoBarra() != null ? connectorRequest
				.getBillersPlusRequest().getCodigoBarra() : "";
		directa.setBarCode(barra.endsWith(recargaConBarra) ? barra.substring(0,barra.length() - recargaConBarra.length()) : barra);
		directa.setUtility(connectorRequest.getBillersPlusRequest().getProductoUtilityCode());
		directa.setMedioPago(connectorRequest.getBillersPlusRequest().getCodigoMedioPago());

		String expandeCheque = parametros.get(ParametrosConector.EXPAND_TAG_CHEQUE_PARAMETER);
		if (expandeCheque != null && ParametrosConector.EXPAND_TAG_CHEQUE_TRUE.equals(expandeCheque.trim())) {
			directa.setCheck(new Check());
		} else {
			directa.setCheck(null);
		}
		// }

		DirectaReqDTO directaReq = new DirectaReqDTO();
		directaReq.setDirecta(directa);
		directaReq.setEndpoint(parametros.get(ParametrosConector.PROXY_ENDPOINT_DIRECTA));

		return directaReq;

	}

	public ConnectorResponse<PagoResponse> getResponseForDirecta(PagoResponse pago, BillerResponseWrapper<?> directa) {
		if (directa == null) {
			logger.warn("La respuesta de la directa es nula");
			return new ConnectorResponse<PagoResponse>(pago, null, null, null);
		}

		if (directa.getResponseBiller() == null) {
			logger.warn("La respuesta wrappeada del biller es nula");
			return new ConnectorResponse<PagoResponse>(pago, null, directa.getRequestBillerTrace(),
					directa.getResponseBillerTrace());
		}

		DirectaResp datosRespuesta = (DirectaResp) directa.getResponseBiller();
		HeaderResp headerRespuesta = datosRespuesta.getHeader();

		logger.debug("Transformando respuesta de DIRECTA con [CodigoProducto = {}]", pago.getProductoUtilityCode());

		pago.setCodigoError(headerRespuesta.getCodError());
		pago.setDescripcionError(getDescripcionError(headerRespuesta.getCodError()));

		ConnectorResponse<PagoResponse> cResponse = new ConnectorResponse<PagoResponse>();
		cResponse.setResponse(pago);
		cResponse.setRequestOriginalBiller(directa.getRequestBillerTrace());
		cResponse.setResponseOriginalBiller(directa.getResponseBillerTrace());

		logger.info("[Conector Codigo {}] Ejecutando DIRECTA con [CodigoProducto {}]",
				PropertyHelper.getConnectorCode(), pago.getProductoUtilityCode());

		return cResponse;
	}

	public Object getReversaRequest(ConnectorRequest connectorRequest) {

		logger.info("[Conector Codigo {}] Ejecutando REVERSA con [CodigoProducto {}] [Version {}]",
				PropertyHelper.getConnectorCode(), connectorRequest.getBillersPlusRequest().getProductoUtilityCode(),
				ParametrosConector.VERSION_PROPERTY);

		Reversa reversa = new Reversa();
		reversa.setHdReq(getHeaderRequest(connectorRequest.getBillersPlusRequest(),
				ParametrosConector.ID_MENSAJE_REVERSA, ParametrosConector.COD_TRX_DIRECTA_REVERSA));
		reversa.setAmount(Integer.valueOf(Decimal.unformat(connectorRequest.getBillersPlusRequest().getImporte())));
		reversa.setUtility(connectorRequest.getBillersPlusRequest().getProductoUtilityCode());
		try {
			DateTime dateTimeZone = DateUtils.getDataTimeZone(
					connectorRequest.getBillersPlusRequest().getFechaHoraFe(), connectorRequest.getBillersPlusRequest()
							.getHusoHorario());
			reversa.setFechaHoraOriginal(DatatypeFactory.newInstance().newXMLGregorianCalendar(
					dateTimeZone.toGregorianCalendar()));
		} catch (DatatypeConfigurationException e) {
			logger.error("Se produjo un error al convertir la fecha ", e);
			reversa.setFechaHoraOriginal(DateUtils.dateToXmlGregorianCalendar(new Date()));
		}
		reversa.setCajeroOriginal(connectorRequest.getBillersPlusRequest().getIdOperador());
		if (connectorRequest.getBillersPlusRequest().getIdTransaccionFe() != null) {
			String idTransaccionFe = String.valueOf(connectorRequest.getBillersPlusRequest().getIdTransaccionFe());
			reversa.setNroSecuenciaOriginal(idTransaccionFe.substring(idTransaccionFe.length() - 4,
					idTransaccionFe.length()));
		} else {
			reversa.setNroSecuenciaOriginal(null);
		}
		reversa.setTipoReversa(connectorRequest.getBillersPlusRequest().getPagoTipoAnulacion());
		reversa.setTerminalOriginal(connectorRequest.getBillersPlusRequest().getIdTerminal());

		ReversaReqDTO reversaReq = new ReversaReqDTO();
		reversaReq.setReversa(reversa);
		Map<String, String> parametros = parametrosConector.getParametrosConectorPorBiller(connectorRequest
				.getBillersPlusRequest().getProductoUtilityCode());
		reversaReq.setEndpoint(parametros.get(ParametrosConector.PROXY_ENDPOINT_REVERSA));

		return reversaReq;

	}

	public ConnectorResponse<PagoResponse> getResponseForReversa(PagoResponse pago, BillerResponseWrapper<?> reversa) {
		if (reversa == null) {
			logger.warn("La respuesta de la directa es nula");
			return new ConnectorResponse<PagoResponse>(pago, null, null, null);
		}

		if (reversa.getResponseBiller() == null) {
			logger.warn("La respuesta wrappeada del biller es nula");
			return new ConnectorResponse<PagoResponse>(pago, null, reversa.getRequestBillerTrace(),
					reversa.getResponseBillerTrace());
		}

		ReversaResp datosRespuesta = (ReversaResp) reversa.getResponseBiller();
		HeaderResp headerRespuesta = datosRespuesta.getHeader();

		logger.debug("Transformando respuesta de DIRECTA con [CodigoProducto = {}]", pago.getProductoUtilityCode());

		pago.setCodigoError(headerRespuesta.getCodError());
		pago.setDescripcionError(getDescripcionError(headerRespuesta.getCodError()));

		ConnectorResponse<PagoResponse> cResponse = new ConnectorResponse<PagoResponse>();
		cResponse.setResponse(pago);
		cResponse.setRequestOriginalBiller(reversa.getRequestBillerTrace());
		cResponse.setResponseOriginalBiller(reversa.getResponseBillerTrace());

		logger.info("[Conector Codigo {}] Ejecutando DIRECTA con [CodigoProducto {}]",
				PropertyHelper.getConnectorCode(), pago.getProductoUtilityCode());

		return cResponse;
	}

	public Object getConsultaEstadoRequest(ConnectorRequest arg0) {
		// TODO: Implementar
		logger.warn("Operacion getConsultaEstadoRequest no implementada");
		return null;
	}

	public ConnectorResponse<PagoResponse> getResponseForConsultaEstado(PagoResponse arg0, BillerResponseWrapper<?> arg1) {
		// TODO: Implementar
		logger.warn("Operacion getResponseForConsultaEstado no implementada");
		return null;
	}

	private HeaderReq getHeaderRequest(BillersPlusRequest billersPlusRequest, String idMensaje, String codTrx) {
		HeaderReq header = new HeaderReq();
		Map<String, String> parametros = parametrosConector.getParametrosConectorPorBiller(billersPlusRequest
				.getProductoUtilityCode());

		header.setAlgoritmo(billersPlusRequest.getDeudaDato1());
		header.setCajero(billersPlusRequest.getIdOperador());
		header.setCodTrx(codTrx);
		try {
			if (ParametrosConector.ID_MENSAJE_CONSULTA_DIRECTA.equals(idMensaje)) {
				DateTime dateTimeZone = DateUtils.getDataTimeZone(billersPlusRequest.getFechaHoraFe(),
						billersPlusRequest.getHusoHorario());
				header.setFechaHora(DatatypeFactory.newInstance().newXMLGregorianCalendar(
						dateTimeZone.toGregorianCalendar()));
			} else {
				DateTime dateTimeZone = DateUtils.getDataTimeZone(new DateTime(), billersPlusRequest.getHusoHorario());
				header.setFechaHora(DatatypeFactory.newInstance().newXMLGregorianCalendar(
						dateTimeZone.toGregorianCalendar()));

			}
		} catch (DatatypeConfigurationException e) {
			logger.error("Se produjo un error al convertir la fecha ", e);
			header.setFechaHora(DateUtils.dateToXmlGregorianCalendar(new Date()));
		}
		header.setIdMensaje(idMensaje);
		header.setMarca(null);
		if (billersPlusRequest.getIdTransaccionFe() != null) {
			String idTransaccionFe = String.valueOf(billersPlusRequest.getIdTransaccionFe());
			header.setNroSecuencia(idTransaccionFe.substring(idTransaccionFe.length() - 4, idTransaccionFe.length()));
		} else {
			header.setNroSecuencia("");
		}
		header.setPlataforma(billersPlusRequest.getPlataforma());
		header.setPuesto(billersPlusRequest.getIdCaja());
		header.setSupervisor(parametros.get(ParametrosConector.SUPERVISOR));
		header.setTerminal(billersPlusRequest.getIdTerminal());
		header.setVersion(null);
		header.setVersionAutorizador(null);

		return header;
	}

	private static String getDescripcionError(int codigoError) {
		switch (codigoError) {
			case 0:
				return "Transacción OK";
			case 1:
				return "Error en DB";
			case 2:
				return "Clave duplicada";
			case 3:
				return "Transacción ya reversada";
			case 4:
				return "No existe la directa (cuando se quiere reversar una transacción que no existe)";
			case 6:
				return "No existe registro (el cliente existe pero no tiene deuda)";
			case 7:
				return "Cliente no existe";
			case 8:
				return "Error de validación del campo de búsqueda";
			case 9:
				return "Parámetros incorrectos o faltantes";
			case 10:
				return "Error interno de la entidad";
			case 13:
				return "Transacción fuera de horario";
			default:
				return "Error desconocido";
		}
	}

	@SuppressWarnings("unused")
	private Check getCheque(String datosAdicionalesMedioPago) {
		Check check = new Check();
		StringTokenizer st = new StringTokenizer(datosAdicionalesMedioPago, "|");
		check.setAccountID(st.nextToken());
		check.setBankBranch(st.nextToken());
		check.setBankID(st.nextToken());
		check.setBankSquare(st.nextToken());
		check.setCheckNumber(st.nextToken());
		check.setAmount(st.nextToken());
		try {
			// Seteo la fecha de vencimiento del cheque. En caso de que
			// el FE no la envie, se setea null
			check.setExpiration(DateUtils.dateToXmlGregorianCalendar(DateUtils.parse(st.nextToken() + "000000",
					DateUtils.FORMAT_YYYYMMDD_HHMMSS)));
		} catch (Exception e) {
			logger.warn("Hubo un problema en la conversion de la fecha de vencimiento. [" + st.nextToken() + "000000]");
			logger.warn("Seteando a NULL");
			check.setExpiration(null);
		}

		return check;
	}

}
