package com.wu.billersplus.service.mock;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.PathParam;

import com.wu.billersplus.framework.connector.service.ConnectorService;
import com.wu.billersplus.framework.connector.service.RegistroResultado;

import ar.com.sepsa.biller.model.product.Product;
import ar.com.sepsa.commons.model.biller.Connector;

/**
 * Clase que sirve de mock para el servicio de Conectores
 * 
 * @author Ramiro Pugh
 * @company Red Hat
 * @email rpugh@redhat.com
 *
 */
public class ConnectorServiceMockOffline implements ConnectorService {

	public RegistroResultado register(Connector connector) throws Exception {

		if (connector.getCode() == null || connector.getName() == null || connector.getParameters() == null
				|| connector.getParameters().isEmpty())
			throw new Exception("INVALID_PARAMTERS");

		RegistroResultado registro = new RegistroResultado();
		registro.setId(127L);
		return registro;
	}

	public List<Connector> getConnectorInstances(@PathParam("code") String code) {

		List<Connector> connectors = new ArrayList<Connector>();
		List<Product> products = new ArrayList<Product>();

		for (Product prd : products)
			connectors.add(prd.getInformation().getConnectorInstance().getAsCommonConnector(prd.getId()));

		return connectors;
	}

}
