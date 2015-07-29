package com.myXMLParser.StAXparser;

import com.myXMLParser.candy.*;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;
import java.util.ArrayList;
import java.util.List;

public class StAXParserClass {
    private XMLInputFactory factory;
    private XMLStreamReader reader;
    private Candy candy;
    private Ingredient ingredient;
    private CandyType candyType;
    private Value value;
    private String tagContent;
    private List<Candy> candyList;

    public List<Candy> StAXParser(String filePath) {
        try {
            factory = XMLInputFactory.newInstance();
            reader = factory.createXMLStreamReader(new StreamSource(filePath));
            while (reader.hasNext()) {
                int evType = reader.next();
                switch (evType) {
                    case XMLStreamReader.START_ELEMENT:
                        checkFirstElement(reader);
                        break;
                    case XMLStreamReader.CHARACTERS:
                        tagContent = reader.getText().trim();
                        break;
                    case XMLStreamReader.END_ELEMENT:
                        checkEndElement(reader);
                        break;
                }
            }
        } catch (XMLStreamException e) {
            System.err.println("XMLException");
        }
        return candyList;
    }

    private void checkFirstElement(XMLStreamReader reader) {
        switch (reader.getLocalName()) {
            case "candies":
                candyList = new ArrayList<Candy>();
                break;
            case "candy":
                candy = new Candy();
                candy.setName(reader.getAttributeValue(0));
                break;
            case "ingredient":
                ingredient = new Ingredient();
                break;
            case "value":
                value = new Value();
        }
    }

    private void checkEndElement(XMLStreamReader reader) {
        switch (reader.getLocalName()) {
            case "candy":
                candyList.add(candy);
                break;
            case "energy":
                candy.setEnergy(Integer.valueOf(tagContent));
                break;
            case "type":
                candyType = new CandyType();
                candyType.setValue(TypeName.fromValue(tagContent));
                break;
            case "name":
                ingredient.setName(tagContent);
                break;
            case "quantity":
                ingredient.setQuantity(Integer.valueOf(tagContent));
                candy.setIngredient(ingredient);
                break;
            case "proteins":
                value.setProteins(Integer.valueOf(tagContent));
                break;
            case "fats":
                value.setFats(Integer.valueOf(tagContent));
                break;
            case "carbohydrates":
                value.setCarbohydrates(Integer.valueOf(tagContent));
                break;
            case "production":
                candy.setProduction(tagContent);
                break;
            case "description":
                candy.setDescription(tagContent);
                break;
        }
        candy.setValue(value);
        candy.setCandyType(candyType);
    }
}
