package com.wu.billersplus.service.mock;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.com.sepsa.commons.model.Labels;
import ar.com.sepsa.commons.model.biller.Biller;
import ar.com.sepsa.commons.model.biller.BillerFlowConfig;
import ar.com.sepsa.commons.model.biller.Connector;
import ar.com.sepsa.commons.model.biller.ConnectorParameter;
import ar.com.sepsa.sei.biller.BillerService;

public class BillerServiceMock implements BillerService{
	
	private static Logger logger = LoggerFactory.getLogger(BillerServiceMock.class);

	public Biller getBiller(Long arg0, String arg1, String arg2, String arg3) {
		logger.warn("Se esta devolviendo una respuesta mockeada nula");
		return null;
	}

	public BillerFlowConfig getConfigForBiller(Long arg0) {
		logger.warn("Se esta devolviendo una respuesta mockeada nula");
		return null;
	}

	public Connector getConnectorInstance(Long arg0) {
		logger.warn("Se esta devolviendo una respuesta mockeada nula");
		Connector connector = new Connector();
		connector.setBillerId(arg0);
		connector.setCode("113322");
		connector.setDescription("Conector Mock");
		List<ConnectorParameter> parameters = new ArrayList<ConnectorParameter>();
		
		connector.setParameters(parameters);
		
		return connector;
		
	}

	public Labels getLabelsForBiller(Long arg0) {
		logger.warn("Se esta devolviendo una respuesta mockeada nula");
		return null;
	}

}
