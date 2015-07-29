package com.myXMLParser.SAXparser;

import com.myXMLParser.candy.*;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SAXHandler extends DefaultHandler {
    private List<Candy> candyList;
    private CandyType candyType;
    private Value value;
    private Candy candy;
    private Ingredient ingredient;
    private String content = null;

    List<Candy> getCandyList() {
        return candyList;
    }

    public void startElement(String uri, String localName, String qName,
                             Attributes attrs) {
        switch (qName) {
            case "candies":
                candyList = new ArrayList<Candy>();
                break;
            case "candy":
                candy = new Candy();
                candy.setName(attrs.getValue("name"));
                break;
            case "ingredient":
                ingredient = new Ingredient();
                break;
            case "value":
                value = new Value();
        }
    }

    public void endElement(String uri, String localName, String qName) {
        switch (qName) {
            case "candy":
                candyList.add(candy);
                break;
            case "energy":
                candy.setEnergy(Integer.valueOf(content));
                break;
            case "type":
                candyType = new CandyType();
                candyType.setValue(TypeName.fromValue(content));
                break;
            case "name":
                ingredient.setName(content);
                break;
            case "quantity":
                ingredient.setQuantity(Integer.valueOf(content));
                candy.setIngredient(ingredient);
                break;
            case "proteins":
                value.setProteins(Integer.valueOf(content));
                break;
            case "fats":
                value.setFats(Integer.valueOf(content));
                break;
            case "carbohydrates":
                value.setCarbohydrates(Integer.valueOf(content));
                break;
            case "production":
                candy.setProduction(content);
                break;
            case "description":
                candy.setDescription(content);
                break;
        }
        candy.setValue(value);
        candy.setCandyType(candyType);
    }

    public void characters(char[] ch, int start, int length) {
        content = String.copyValueOf(ch, start, length).trim();
    }
}
