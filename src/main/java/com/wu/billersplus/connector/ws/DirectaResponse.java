
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
 *         &lt;element name="directaReturn" type="{http://operationsDataTypes.genericows.sibs.com.ar}DirectaResp"/>
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
    "directaReturn"
})
@XmlRootElement(name = "directaResponse")
public class DirectaResponse {

    @XmlElement(required = true)
    protected DirectaResp directaReturn;

    /**
     * Obtiene el valor de la propiedad directaReturn.
     * 
     * @return
     *     possible object is
     *     {@link DirectaResp }
     *     
     */
    public DirectaResp getDirectaReturn() {
        return directaReturn;
    }

    /**
     * Define el valor de la propiedad directaReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link DirectaResp }
     *     
     */
    public void setDirectaReturn(DirectaResp value) {
        this.directaReturn = value;
    }

}
