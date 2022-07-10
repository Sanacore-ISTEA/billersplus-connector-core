package com.wu.billersplus.connector.entities;

/**
 * Clase que podría usarse como parámetros del conector así todas las properties
 * están configuradas en un solo lugar
 *
 */
public class ParametrosConector {

	public static final String PROXY_TIMEOUT_PROPERTY = "client.connectionTimeout";
	public static final String PROXY_URL_PARAMETER = "client.url";
	public static final String PROXY_SOCKETTIMEOUT_PROPERTY = "client.socketTimeout";
	public static final String USUARIO_PROPERTY = "usuario";
	public static final String PROXY_URL_WET_PARAMETER = "client.url.get";
	public static final String EXPAND_TAG_CHEQUE_PARAMETER = "expandTagCheque";
	public static final String PROXY_ENDPOINT_CONSULTA = "client.url.consulta";
	public static final String PROXY_ENDPOINT_DIRECTA = "client.url.directa";
	public static final String PROXY_ENDPOINT_REVERSA = "client.url.reversa";
	public static final String RECARGA_CON_BARRA = "recarga.con.barra";

	public static final String SEPARATOR_PROPERTY = ".";

	public static final String COD_TRX_CONSULTA = "06650";
	public static final String ID_MENSAJE_CONSULTA_DIRECTA = "D";

	public static final String COD_TRX_DIRECTA_REVERSA = "06880";
	public static final String ID_MENSAJE_REVERSA = "R";

	public static final String EXPAND_TAG_CHEQUE_TRUE 	= "S";

	public static final String IDENTIFICADOR_MEDIO_PAGO_CHEQUE 	= "C";
	public static final String ESTADO_DISPONIBLE = "D";
	public static final String SUPERVISOR = "supervisor.sf2";

	public static final String VERSION_PROPERTY = "1.0.0.6";
}
