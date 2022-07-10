package com.wu.billersplus.connector.utils;

import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class SOAPLoggingHandler implements SOAPHandler<SOAPMessageContext> {

	public Set<QName> getHeaders() {
		return null;
	}
	/**
	 *
	 */
	public boolean handleMessage(SOAPMessageContext arg0) {
		SOAPMessage message = arg0.getMessage();
		boolean isOutboundMessage = (Boolean) arg0.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		if (isOutboundMessage) {
			System.out.println("OUTBOUND MESSAGE");
		} else {
			System.out.println("INBOUND MESSAGE");
		}
		try {
			Source source = message.getSOAPPart().getContent();

			Transformer transformer = TransformerFactory.newInstance().newTransformer();

			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "1");

			transformer.transform(source, new StreamResult(System.out));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean handleFault(SOAPMessageContext smc) {
		return true;
	}

	// nothing to clean up
	public void close(MessageContext messageContext) {
	}

}