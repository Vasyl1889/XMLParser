package com.myXMLParser.candy;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@XmlRootElement(name = "productions")
@XmlType(propOrder = {"candy"})
public class Candies {
    @XmlElement(required = true)
    private List<Candy> candy = new ArrayList<>();

    public void setCandyList(List<Candy> list) {
        this.candy = list;
    }

    public void sortCandyListByName() {
        Comparator<Candy> compareByStringOne = new Comparator<Candy>() {
            @Override
            public int compare(Candy str1, Candy str2) {
                return str1.getName().compareTo(str2.getName());
            }
        };
        Collections.sort(this.candy, compareByStringOne);
    }

    public void printCandyList() {
        for (Candy candy : this.candy) {
            candy.print();
        }
    }

    public List<Candy> getCandy() {
        return candy;
    }
}