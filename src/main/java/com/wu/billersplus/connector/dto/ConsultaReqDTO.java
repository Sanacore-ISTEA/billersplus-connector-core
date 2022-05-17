package com.wu.billersplus.connector.dto;

import com.wu.billersplus.connector.ws.Consulta;

public class ConsultaReqDTO {

	private Consulta consulta;
	private String endpoint;

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

}
