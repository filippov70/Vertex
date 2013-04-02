//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.04.02 at 06:25:35 PM NOVT 
//


package org.tomskgislab.vertex.xml.zem.zone.classes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dApartmentType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="dApartmentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="кв"/>
 *     &lt;enumeration value="бокс"/>
 *     &lt;enumeration value="к"/>
 *     &lt;enumeration value="пом"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "dApartmentType")
@XmlEnum
public enum DApartmentType {


    /**
     * Квартира
     * 
     */
    @XmlEnumValue("\u043a\u0432")
    КВ("\u043a\u0432"),

    /**
     * Бокс
     * 
     */
    @XmlEnumValue("\u0431\u043e\u043a\u0441")
    БОКС("\u0431\u043e\u043a\u0441"),

    /**
     * Комната
     * 
     */
    @XmlEnumValue("\u043a")
    К("\u043a"),

    /**
     * Помещение
     * 
     */
    @XmlEnumValue("\u043f\u043e\u043c")
    ПОМ("\u043f\u043e\u043c");
    private final String value;

    DApartmentType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DApartmentType fromValue(String v) {
        for (DApartmentType c: DApartmentType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
