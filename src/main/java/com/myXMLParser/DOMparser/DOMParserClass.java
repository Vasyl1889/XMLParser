package com.myXMLParser.DOMparser;

import com.myXMLParser.candy.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DOMParserClass {
    private List<Candy> candyList = new ArrayList<>();

    private String getValue(Element e, String name) {
        NodeList nList = e.getElementsByTagName(name);
        Element elem = (Element) nList.item(0);
        Text t = (Text) elem.getFirstChild();
        return t.getNodeValue();
    }

    public List<Candy> DOMParser(String filePath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory
                    .newInstance();

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(filePath);
            NodeList nodeList = document.getElementsByTagName("candy");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Candy candy = new Candy();
                    Element eElement = (Element) node;
                    Node name = eElement.getAttributes().item(0);
                    candy.setName(name.getNodeValue());
                    candy.setEnergy(Integer.parseInt(getValue(eElement,
                            "energy")));

                    CandyType candyType = new CandyType();
                    candyType.setValue(TypeName.fromValue(getValue(eElement,
                            "type")));
                    candy.setCandyType(candyType);

                    Element ingreds = (Element) eElement.getElementsByTagName(
                            "ingredients").item(0);
                    NodeList ingredList = ingreds
                            .getElementsByTagName("ingredient");
                    Element ingredElem;
                    for (int j = 0; j < ingredList.getLength(); j++) {
                        ingredElem = (Element) ingredList.item(j);
                        Ingredient ingred = new Ingredient();
                        ingred.setName(getValue(ingredElem, "name"));
                        ingred.setQuantity(Integer.parseInt(getValue(
                                ingredElem, "quantity")));
                        candy.setIngredient(ingred);
                    }
                    Element values = (Element) eElement.getElementsByTagName(
                            "value").item(0);

                    Value candyValue = new Value();
                    candyValue.setFats(Integer
                            .parseInt(getValue(values, "fats")));
                    candyValue.setProteins(Integer.parseInt(getValue(values,
                            "proteins")));
                    candyValue.setCarbohydrates(Integer.parseInt(getValue(
                            values, "carbohydrates")));
                    candy.setValue(candyValue);
                    candy.setProduction(getValue(eElement, "production"));
                    candy.setDescription(getValue(eElement, "description"));
                    candyList.add(candy);
                }
            }
        } catch (ParserConfigurationException e) {
            System.err.println("Parser Config Error");
        } catch (IOException e) {
            System.err.println("Wrong Filepath");
        } catch (SAXException e) {
            System.err.println("SAXException");
        } catch (Exception e) {
            System.err.println("Exception");
        }
        return candyList;
    }
}
