//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.04.02 at 06:25:35 PM NOVT 
//


package org.tomskgislab.vertex.xml.zem.zone.classes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Зона с особыми условиями использования территории
 * 
 * <p>Java class for tSpecialZones complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tSpecialZones">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ContentRestrictions">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="4000"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tSpecialZones", propOrder = {
    "contentRestrictions"
})
public class TSpecialZones {

    @XmlElement(name = "ContentRestrictions", required = true)
    protected String contentRestrictions;

    /**
     * Gets the value of the contentRestrictions property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContentRestrictions() {
        return contentRestrictions;
    }

    /**
     * Sets the value of the contentRestrictions property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContentRestrictions(String value) {
        this.contentRestrictions = value;
    }

}