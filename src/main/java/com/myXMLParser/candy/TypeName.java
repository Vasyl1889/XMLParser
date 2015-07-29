package com.myXMLParser.candy;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "TypeName")
@XmlEnum
public enum TypeName {
    @XmlEnumValue("Chocolate")
    CHOCOLATE("Chocolate"), @XmlEnumValue("Caramel")
    CARAMEL("Caramel"), @XmlEnumValue("Iris")
    IRIS("Iris"), @XmlEnumValue("Chocolate with filling")
    CHOCOLATE_WITH_FILLING(
            "Chocolate with filling");
    private final String value;

    TypeName(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TypeName fromValue(String v) {
        for (TypeName c : TypeName.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
