package com.myXMLParser.marshal;

import com.myXMLParser.DOMparser.DOMParserClass;
import com.myXMLParser.candy.Candies;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MarshalClass {
    public static void marshalToNewXML(String xmlFilePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(Candies.class);
            Marshaller m = context.createMarshaller();

            DOMParserClass domParser = new DOMParserClass();

            Candies candies = new Candies();
            candies.setCandyList(domParser.DOMParser(xmlFilePath));
            candies.sortCandyListByName();

            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(candies, new FileOutputStream("NewCandyXML.xml"));
            // m.marshal(candies, System.out); // копiя на консоль
            System.out.println("XML file is created.");
        } catch (JAXBException e) {
            System.err.println("JAXBException");
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException");
            e.printStackTrace();
        }
    }
}