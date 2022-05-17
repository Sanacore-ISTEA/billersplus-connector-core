
package com.wu.billersplus.connector.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayFieldsQuerie complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayFieldsQuerie">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cob_cod_barra" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cob_prior_gpo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cob_prior_nro" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cob_texto_fe" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cob_estado" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cob_cobro_tipo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cob_comp_imp" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numero_de_orden" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayFieldsQuerie", namespace = "http://dataTypes.genericows.sibs.com.ar", propOrder = {
    "cobCodBarra",
    "cobPriorGpo",
    "cobPriorNro",
    "cobTextoFe",
    "cobEstado",
    "cobCobroTipo",
    "cobCompImp",
    "numeroDeOrden"
})
public class ArrayFieldsQuerie {

    @XmlElement(name = "cob_cod_barra", required = true, nillable = true)
    protected String cobCodBarra;
    @XmlElement(name = "cob_prior_gpo", required = true, nillable = true)
    protected String cobPriorGpo;
    @XmlElement(name = "cob_prior_nro", required = true, nillable = true)
    protected String cobPriorNro;
    @XmlElement(name = "cob_texto_fe", required = true, nillable = true)
    protected String cobTextoFe;
    @XmlElement(name = "cob_estado", required = true, nillable = true)
    protected String cobEstado;
    @XmlElement(name = "cob_cobro_tipo", required = true, nillable = true)
    protected String cobCobroTipo;
    @XmlElement(name = "cob_comp_imp", required = true, type = Integer.class, nillable = true)
    protected Integer cobCompImp;
    @XmlElement(name = "numero_de_orden", required = true, type = Integer.class, nillable = true)
    protected Integer numeroDeOrden;

    /**
     * Obtiene el valor de la propiedad cobCodBarra.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCobCodBarra() {
        return cobCodBarra;
    }

    /**
     * Define el valor de la propiedad cobCodBarra.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCobCodBarra(String value) {
        this.cobCodBarra = value;
    }

    /**
     * Obtiene el valor de la propiedad cobPriorGpo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCobPriorGpo() {
        return cobPriorGpo;
    }

    /**
     * Define el valor de la propiedad cobPriorGpo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCobPriorGpo(String value) {
        this.cobPriorGpo = value;
    }

    /**
     * Obtiene el valor de la propiedad cobPriorNro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCobPriorNro() {
        return cobPriorNro;
    }

    /**
     * Define el valor de la propiedad cobPriorNro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCobPriorNro(String value) {
        this.cobPriorNro = value;
    }

    /**
     * Obtiene el valor de la propiedad cobTextoFe.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCobTextoFe() {
        return cobTextoFe;
    }

    /**
     * Define el valor de la propiedad cobTextoFe.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCobTextoFe(String value) {
        this.cobTextoFe = value;
    }

    /**
     * Obtiene el valor de la propiedad cobEstado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCobEstado() {
        return cobEstado;
    }

    /**
     * Define el valor de la propiedad cobEstado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCobEstado(String value) {
        this.cobEstado = value;
    }

    /**
     * Obtiene el valor de la propiedad cobCobroTipo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCobCobroTipo() {
        return cobCobroTipo;
    }

    /**
     * Define el valor de la propiedad cobCobroTipo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCobCobroTipo(String value) {
        this.cobCobroTipo = value;
    }

    /**
     * Obtiene el valor de la propiedad cobCompImp.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCobCompImp() {
        return cobCompImp;
    }

    /**
     * Define el valor de la propiedad cobCompImp.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCobCompImp(Integer value) {
        this.cobCompImp = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroDeOrden.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumeroDeOrden() {
        return numeroDeOrden;
    }

    /**
     * Define el valor de la propiedad numeroDeOrden.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumeroDeOrden(Integer value) {
        this.numeroDeOrden = value;
    }

}
