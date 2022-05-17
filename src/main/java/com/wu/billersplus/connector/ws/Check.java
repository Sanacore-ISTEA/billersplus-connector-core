
package com.wu.billersplus.connector.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para Check complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Check">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bankBranch" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bankID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bankSquare" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="checkNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="expiration" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Check", namespace = "http://dataTypes.genericows.sibs.com.ar", propOrder = {
    "accountID",
    "amount",
    "bankBranch",
    "bankID",
    "bankSquare",
    "checkNumber",
    "expiration"
})
public class Check {

    @XmlElement(required = true, nillable = true)
    protected String accountID;
    @XmlElement(required = true, nillable = true)
    protected String amount;
    @XmlElement(required = true, nillable = true)
    protected String bankBranch;
    @XmlElement(required = true, nillable = true)
    protected String bankID;
    @XmlElement(required = true, nillable = true)
    protected String bankSquare;
    @XmlElement(required = true, nillable = true)
    protected String checkNumber;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expiration;

    /**
     * Obtiene el valor de la propiedad accountID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountID() {
        return accountID;
    }

    /**
     * Define el valor de la propiedad accountID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountID(String value) {
        this.accountID = value;
    }

    /**
     * Obtiene el valor de la propiedad amount.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmount() {
        return amount;
    }

    /**
     * Define el valor de la propiedad amount.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmount(String value) {
        this.amount = value;
    }

    /**
     * Obtiene el valor de la propiedad bankBranch.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankBranch() {
        return bankBranch;
    }

    /**
     * Define el valor de la propiedad bankBranch.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankBranch(String value) {
        this.bankBranch = value;
    }

    /**
     * Obtiene el valor de la propiedad bankID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankID() {
        return bankID;
    }

    /**
     * Define el valor de la propiedad bankID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankID(String value) {
        this.bankID = value;
    }

    /**
     * Obtiene el valor de la propiedad bankSquare.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankSquare() {
        return bankSquare;
    }

    /**
     * Define el valor de la propiedad bankSquare.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankSquare(String value) {
        this.bankSquare = value;
    }

    /**
     * Obtiene el valor de la propiedad checkNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCheckNumber() {
        return checkNumber;
    }

    /**
     * Define el valor de la propiedad checkNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCheckNumber(String value) {
        this.checkNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad expiration.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpiration() {
        return expiration;
    }

    /**
     * Define el valor de la propiedad expiration.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpiration(XMLGregorianCalendar value) {
        this.expiration = value;
    }

}
