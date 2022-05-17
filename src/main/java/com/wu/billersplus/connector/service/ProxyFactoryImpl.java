package com.wu.billersplus.connector.service;

import javax.ejb.Stateless;

import com.wu.billersplus.framework.cdi.qualifiers.BillerPlusServiceBean;
import com.wu.billersplus.framework.service.ProxyFactory;
import com.wu.billersplus.framework.service.ProxyService;

@Stateless
@BillerPlusServiceBean
public class ProxyFactoryImpl implements ProxyFactory {

	/**
	 * Este metodo debe devolver instancias de nuestra implementación de
	 * ProxyService. En este caso y por default se utiliza la clase generada por
	 * el arquetipo, ProxyServiceImpl
	 */
	public ProxyService createInstance() {
		return new ProxyServiceImpl();
	}

}
