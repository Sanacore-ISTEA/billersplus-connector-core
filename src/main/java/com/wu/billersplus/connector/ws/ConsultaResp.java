
package com.wu.billersplus.connector.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ConsultaResp complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ConsultaResp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cob_cliente_nomb" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="count" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fields" type="{http://operations.genericows.sibs.com.ar}ArrayOf_tns1_ArrayFieldsQuerie"/>
 *         &lt;element name="header" type="{http://dataTypes.genericows.sibs.com.ar}HeaderResp"/>
 *         &lt;element name="seleccion_con_prioridad" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultaResp", namespace = "http://operationsDataTypes.genericows.sibs.com.ar", propOrder = {
    "cobClienteNomb",
    "count",
    "fields",
    "header",
    "seleccionConPrioridad"
})
public class ConsultaResp {

    @XmlElement(name = "cob_cliente_nomb", required = true, nillable = true)
    protected String cobClienteNomb;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer count;
    @XmlElement(required = true, nillable = true)
    protected ArrayOfTns1ArrayFieldsQuerie fields;
    @XmlElement(required = true, nillable = true)
    protected HeaderResp header;
    @XmlElement(name = "seleccion_con_prioridad", required = true, type = Integer.class, nillable = true)
    protected Integer seleccionConPrioridad;

    /**
     * Obtiene el valor de la propiedad cobClienteNomb.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCobClienteNomb() {
        return cobClienteNomb;
    }

    /**
     * Define el valor de la propiedad cobClienteNomb.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCobClienteNomb(String value) {
        this.cobClienteNomb = value;
    }

    /**
     * Obtiene el valor de la propiedad count.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCount() {
        return count;
    }

    /**
     * Define el valor de la propiedad count.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCount(Integer value) {
        this.count = value;
    }

    /**
     * Obtiene el valor de la propiedad fields.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTns1ArrayFieldsQuerie }
     *     
     */
    public ArrayOfTns1ArrayFieldsQuerie getFields() {
        return fields;
    }

    /**
     * Define el valor de la propiedad fields.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTns1ArrayFieldsQuerie }
     *     
     */
    public void setFields(ArrayOfTns1ArrayFieldsQuerie value) {
        this.fields = value;
    }

    /**
     * Obtiene el valor de la propiedad header.
     * 
     * @return
     *     possible object is
     *     {@link HeaderResp }
     *     
     */
    public HeaderResp getHeader() {
        return header;
    }

    /**
     * Define el valor de la propiedad header.
     * 
     * @param value
     *     allowed object is
     *     {@link HeaderResp }
     *     
     */
    public void setHeader(HeaderResp value) {
        this.header = value;
    }

    /**
     * Obtiene el valor de la propiedad seleccionConPrioridad.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSeleccionConPrioridad() {
        return seleccionConPrioridad;
    }

    /**
     * Define el valor de la propiedad seleccionConPrioridad.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSeleccionConPrioridad(Integer value) {
        this.seleccionConPrioridad = value;
    }

}
