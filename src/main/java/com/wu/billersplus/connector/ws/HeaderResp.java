
package com.wu.billersplus.connector.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para HeaderResp complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="HeaderResp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="algoritmo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cajero" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codError" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="codSeveridad" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fechaHora" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="idMensaje" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="marca" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nroSecuencia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="terminal" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HeaderResp", namespace = "http://dataTypes.genericows.sibs.com.ar", propOrder = {
    "algoritmo",
    "cajero",
    "codError",
    "codSeveridad",
    "fechaHora",
    "idMensaje",
    "marca",
    "nroSecuencia",
    "terminal",
    "version"
})
public class HeaderResp {

    @XmlElement(required = true, nillable = true)
    protected String algoritmo;
    @XmlElement(required = true, nillable = true)
    protected String cajero;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer codError;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer codSeveridad;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaHora;
    @XmlElement(required = true, nillable = true)
    protected String idMensaje;
    @XmlElement(required = true, nillable = true)
    protected String marca;
    @XmlElement(required = true, nillable = true)
    protected String nroSecuencia;
    @XmlElement(required = true, nillable = true)
    protected String terminal;
    @XmlElement(required = true, nillable = true)
    protected String version;

    /**
     * Obtiene el valor de la propiedad algoritmo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlgoritmo() {
        return algoritmo;
    }

    /**
     * Define el valor de la propiedad algoritmo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlgoritmo(String value) {
        this.algoritmo = value;
    }

    /**
     * Obtiene el valor de la propiedad cajero.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCajero() {
        return cajero;
    }

    /**
     * Define el valor de la propiedad cajero.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCajero(String value) {
        this.cajero = value;
    }

    /**
     * Obtiene el valor de la propiedad codError.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodError() {
        return codError;
    }

    /**
     * Define el valor de la propiedad codError.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodError(Integer value) {
        this.codError = value;
    }

    /**
     * Obtiene el valor de la propiedad codSeveridad.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodSeveridad() {
        return codSeveridad;
    }

    /**
     * Define el valor de la propiedad codSeveridad.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodSeveridad(Integer value) {
        this.codSeveridad = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaHora.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaHora() {
        return fechaHora;
    }

    /**
     * Define el valor de la propiedad fechaHora.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaHora(XMLGregorianCalendar value) {
        this.fechaHora = value;
    }

    /**
     * Obtiene el valor de la propiedad idMensaje.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdMensaje() {
        return idMensaje;
    }

    /**
     * Define el valor de la propiedad idMensaje.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdMensaje(String value) {
        this.idMensaje = value;
    }

    /**
     * Obtiene el valor de la propiedad marca.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Define el valor de la propiedad marca.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarca(String value) {
        this.marca = value;
    }

    /**
     * Obtiene el valor de la propiedad nroSecuencia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNroSecuencia() {
        return nroSecuencia;
    }

    /**
     * Define el valor de la propiedad nroSecuencia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNroSecuencia(String value) {
        this.nroSecuencia = value;
    }

    /**
     * Obtiene el valor de la propiedad terminal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerminal() {
        return terminal;
    }

    /**
     * Define el valor de la propiedad terminal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerminal(String value) {
        this.terminal = value;
    }

    /**
     * Obtiene el valor de la propiedad version.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Define el valor de la propiedad version.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

}
