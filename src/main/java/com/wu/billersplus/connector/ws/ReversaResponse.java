
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
 *         &lt;element name="reversaReturn" type="{http://operationsDataTypes.genericows.sibs.com.ar}ReversaResp"/>
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
    "reversaReturn"
})
@XmlRootElement(name = "reversaResponse")
public class ReversaResponse {

    @XmlElement(required = true)
    protected ReversaResp reversaReturn;

    /**
     * Obtiene el valor de la propiedad reversaReturn.
     * 
     * @return
     *     possible object is
     *     {@link ReversaResp }
     *     
     */
    public ReversaResp getReversaReturn() {
        return reversaReturn;
    }

    /**
     * Define el valor de la propiedad reversaReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link ReversaResp }
     *     
     */
    public void setReversaReturn(ReversaResp value) {
        this.reversaReturn = value;
    }

}
