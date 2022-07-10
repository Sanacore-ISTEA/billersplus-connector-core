
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
 *         &lt;element name="check" type="{http://dataTypes.genericows.sibs.com.ar}Check"/>
 *         &lt;element name="utility" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="barCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="medioPago" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="creditCard" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "check",
    "utility",
    "barCode",
    "medioPago",
    "creditCard",
    "amount"
})
@XmlRootElement(name = "directa")
public class Directa {

    @XmlElement(required = true)
    protected HeaderReq hdReq;
    @XmlElement(required = true)
    protected Check check;
    @XmlElement(required = true)
    protected String utility;
    @XmlElement(required = true)
    protected String barCode;
    @XmlElement(required = true)
    protected String medioPago;
    @XmlElement(required = true)
    protected String creditCard;
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
     * Obtiene el valor de la propiedad check.
     * 
     * @return
     *     possible object is
     *     {@link Check }
     *     
     */
    public Check getCheck() {
        return check;
    }

    /**
     * Define el valor de la propiedad check.
     * 
     * @param value
     *     allowed object is
     *     {@link Check }
     *     
     */
    public void setCheck(Check value) {
        this.check = value;
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
     * Obtiene el valor de la propiedad barCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBarCode() {
        return barCode;
    }

    /**
     * Define el valor de la propiedad barCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBarCode(String value) {
        this.barCode = value;
    }

    /**
     * Obtiene el valor de la propiedad medioPago.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedioPago() {
        return medioPago;
    }

    /**
     * Define el valor de la propiedad medioPago.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedioPago(String value) {
        this.medioPago = value;
    }

    /**
     * Obtiene el valor de la propiedad creditCard.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditCard() {
        return creditCard;
    }

    /**
     * Define el valor de la propiedad creditCard.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditCard(String value) {
        this.creditCard = value;
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
