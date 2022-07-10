
package com.wu.billersplus.connector.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="terminalOriginal" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cajeroOriginal" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fechaHoraOriginal" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="nroSecuenciaOriginal" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tipoReversa" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="utility" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "terminalOriginal",
    "cajeroOriginal",
    "fechaHoraOriginal",
    "nroSecuenciaOriginal",
    "tipoReversa",
    "utility",
    "amount"
})
@XmlRootElement(name = "reversa")
public class Reversa {

    @XmlElement(required = true)
    protected HeaderReq hdReq;
    @XmlElement(required = true)
    protected String terminalOriginal;
    @XmlElement(required = true)
    protected String cajeroOriginal;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaHoraOriginal;
    @XmlElement(required = true)
    protected String nroSecuenciaOriginal;
    @XmlElement(required = true)
    protected String tipoReversa;
    @XmlElement(required = true)
    protected String utility;
    protected int amount;

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
     * Obtiene el valor de la propiedad terminalOriginal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerminalOriginal() {
        return terminalOriginal;
    }

    /**
     * Define el valor de la propiedad terminalOriginal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerminalOriginal(String value) {
        this.terminalOriginal = value;
    }

    /**
     * Obtiene el valor de la propiedad cajeroOriginal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCajeroOriginal() {
        return cajeroOriginal;
    }

    /**
     * Define el valor de la propiedad cajeroOriginal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCajeroOriginal(String value) {
        this.cajeroOriginal = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaHoraOriginal.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaHoraOriginal() {
        return fechaHoraOriginal;
    }

    /**
     * Define el valor de la propiedad fechaHoraOriginal.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaHoraOriginal(XMLGregorianCalendar value) {
        this.fechaHoraOriginal = value;
    }

    /**
     * Obtiene el valor de la propiedad nroSecuenciaOriginal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNroSecuenciaOriginal() {
        return nroSecuenciaOriginal;
    }

    /**
     * Define el valor de la propiedad nroSecuenciaOriginal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNroSecuenciaOriginal(String value) {
        this.nroSecuenciaOriginal = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoReversa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoReversa() {
        return tipoReversa;
    }

    /**
     * Define el valor de la propiedad tipoReversa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoReversa(String value) {
        this.tipoReversa = value;
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
     * Obtiene el valor de la propiedad amount.
     * 
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Define el valor de la propiedad amount.
     * 
     */
    public void setAmount(int value) {
        this.amount = value;
    }

}
