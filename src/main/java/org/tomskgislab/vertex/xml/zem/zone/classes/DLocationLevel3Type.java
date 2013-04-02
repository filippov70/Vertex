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
 * <p>Java class for dLocationLevel3Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="dLocationLevel3Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="строен"/>
 *     &lt;enumeration value="корп"/>
 *     &lt;enumeration value="блок"/>
 *     &lt;enumeration value="литера"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "dLocationLevel3Type")
@XmlEnum
public enum DLocationLevel3Type {


    /**
     * Строение
     * 
     */
    @XmlEnumValue("\u0441\u0442\u0440\u043e\u0435\u043d")
    СТРОЕН("\u0441\u0442\u0440\u043e\u0435\u043d"),

    /**
     * Корпус
     * 
     */
    @XmlEnumValue("\u043a\u043e\u0440\u043f")
    КОРП("\u043a\u043e\u0440\u043f"),

    /**
     * Блок
     * 
     */
    @XmlEnumValue("\u0431\u043b\u043e\u043a")
    БЛОК("\u0431\u043b\u043e\u043a"),

    /**
     * литера
     * 
     */
    @XmlEnumValue("\u043b\u0438\u0442\u0435\u0440\u0430")
    ЛИТЕРА("\u043b\u0438\u0442\u0435\u0440\u0430");
    private final String value;

    DLocationLevel3Type(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DLocationLevel3Type fromValue(String v) {
        for (DLocationLevel3Type c: DLocationLevel3Type.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
