package com.wu.billersplus.connector.dto;

import com.wu.billersplus.connector.ws.Directa;

public class DirectaReqDTO {

	private Directa directa;
	private String endpoint;

	public Directa getDirecta() {
		return directa;
	}

	public void setDirecta(Directa directa) {
		this.directa = directa;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

}
