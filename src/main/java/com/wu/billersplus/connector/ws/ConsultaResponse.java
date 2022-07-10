
package com.wu.billersplus.connector.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="consultaReturn" type="{http://operationsDataTypes.genericows.sibs.com.ar}ConsultaResp"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "consultaReturn"
})
@XmlRootElement(name = "consultaResponse")
public class ConsultaResponse {

    @XmlElement(required = true)
    protected ConsultaResp consultaReturn;

    /**
     * Obtiene el valor de la propiedad consultaReturn.
     * 
     * @return
     *     possible object is
     *     {@link ConsultaResp }
     *     
     */
    public ConsultaResp getConsultaReturn() {
        return consultaReturn;
    }

    /**
     * Define el valor de la propiedad consultaReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsultaResp }
     *     
     */
    public void setConsultaReturn(ConsultaResp value) {
        this.consultaReturn = value;
    }

}
