
package com.wu.billersplus.connector.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para HeaderReq complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="HeaderReq">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="algoritmo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cajero" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codTrx" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fechaHora" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="idMensaje" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="marca" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nroSecuencia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="plataforma" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="puesto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="supervisor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="terminal" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="versionAutorizador" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HeaderReq", namespace = "http://dataTypes.genericows.sibs.com.ar", propOrder = {
    "algoritmo",
    "cajero",
    "codTrx",
    "fechaHora",
    "idMensaje",
    "marca",
    "nroSecuencia",
    "plataforma",
    "puesto",
    "supervisor",
    "terminal",
    "version",
    "versionAutorizador"
})
public class HeaderReq {

    @XmlElement(required = true, nillable = true)
    protected String algoritmo;
    @XmlElement(required = true, nillable = true)
    protected String cajero;
    @XmlElement(required = true, nillable = true)
    protected String codTrx;
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
    protected String plataforma;
    @XmlElement(required = true, nillable = true)
    protected String puesto;
    @XmlElement(required = true, nillable = true)
    protected String supervisor;
    @XmlElement(required = true, nillable = true)
    protected String terminal;
    @XmlElement(required = true, nillable = true)
    protected String version;
    @XmlElement(required = true, nillable = true)
    protected String versionAutorizador;

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
     * Obtiene el valor de la propiedad codTrx.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTrx() {
        return codTrx;
    }

    /**
     * Define el valor de la propiedad codTrx.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTrx(String value) {
        this.codTrx = value;
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
     * Obtiene el valor de la propiedad plataforma.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlataforma() {
        return plataforma;
    }

    /**
     * Define el valor de la propiedad plataforma.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlataforma(String value) {
        this.plataforma = value;
    }

    /**
     * Obtiene el valor de la propiedad puesto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPuesto() {
        return puesto;
    }

    /**
     * Define el valor de la propiedad puesto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPuesto(String value) {
        this.puesto = value;
    }

    /**
     * Obtiene el valor de la propiedad supervisor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupervisor() {
        return supervisor;
    }

    /**
     * Define el valor de la propiedad supervisor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupervisor(String value) {
        this.supervisor = value;
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

    /**
     * Obtiene el valor de la propiedad versionAutorizador.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersionAutorizador() {
        return versionAutorizador;
    }

    /**
     * Define el valor de la propiedad versionAutorizador.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersionAutorizador(String value) {
        this.versionAutorizador = value;
    }

}
