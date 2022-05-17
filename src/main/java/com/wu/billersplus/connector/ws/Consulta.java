
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
 *         &lt;element name="hdReq" type="{http://dataTypes.genericows.sibs.com.ar}HeaderReq"/>
 *         &lt;element name="utility" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cod_barra" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codigo_cliente" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "hdReq",
    "utility",
    "codBarra",
    "codigoCliente"
})
@XmlRootElement(name = "consulta")
public class Consulta {

    @XmlElement(required = true)
    protected HeaderReq hdReq;
    @XmlElement(required = true)
    protected String utility;
    @XmlElement(name = "cod_barra", required = true)
    protected String codBarra;
    @XmlElement(name = "codigo_cliente", required = true)
    protected String codigoCliente;

    /**
     * Obtiene el valor de la propiedad hdReq.
     * 
     * @return
     *     possible object is
     *     {@link HeaderReq }
     *     
     */
    public HeaderReq getHdReq() {
        return hdReq;
    }

    /**
     * Define el valor de la propiedad hdReq.
     * 
     * @param value
     *     allowed object is
     *     {@link HeaderReq }
     *     
     */
    public void setHdReq(HeaderReq value) {
        this.hdReq = value;
    }

    /**
     * Obtiene el valor de la propiedad utility.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUtility() {
        return utility;
    }

    /**
     * Define el valor de la propiedad utility.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUtility(String value) {
        this.utility = value;
    }

    /**
     * Obtiene el valor de la propiedad codBarra.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodBarra() {
        return codBarra;
    }

    /**
     * Define el valor de la propiedad codBarra.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodBarra(String value) {
        this.codBarra = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoCliente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoCliente() {
        return codigoCliente;
    }

    /**
     * Define el valor de la propiedad codigoCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoCliente(String value) {
        this.codigoCliente = value;
    }

}
