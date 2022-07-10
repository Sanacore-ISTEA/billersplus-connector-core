package com.wu.billersplus.connector.dto;

import com.wu.billersplus.connector.ws.Reversa;

public class ReversaReqDTO {

	private Reversa reversa;
	private String endpoint;

	public Reversa getReversa() {
		return reversa;
	}

	public void setReversa(Reversa reversa) {
		this.reversa = reversa;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

}
