package com.myXMLParser.candy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"value"})
public class CandyType {
    @XmlValue
    protected TypeName value;

    public TypeName getValue() {
        return value;
    }

    public void setValue(TypeName value) {
        this.value = value;
    }
}
