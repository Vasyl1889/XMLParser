package com.myXMLParser.transformer;

import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class TransformerClass {
    public static void transformToHTML(String xmlFilePath, String xslFilePath) {
        try {
            TransformerFactory tFact = TransformerFactory.newInstance();
            javax.xml.transform.Transformer transformer = tFact
                    .newTransformer(new StreamSource(xslFilePath));
            transformer.transform(new StreamSource(xmlFilePath), new StreamResult("candy.html"));
            System.out.println("Transform is successful.");
        } catch (TransformerException e) {
            System.out.println("Transform is not successful.");
        }
    }
}