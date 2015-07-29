package com.myXMLParser.helper;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class ValidatorSAXXSD {
    public static boolean isXMLValid(String xmlFilePath, String xsdFilePath) {
        boolean isDocumentValid = false;
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(xsdFilePath);

        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(xmlFilePath);
            validator.validate(source);
            // System.out.println(fileName + " is valid.");
            isDocumentValid = true;
        } catch (SAXException e) {
            System.err.print("validation " + xmlFilePath
                    + " is not valid because " + e.getMessage());
        } catch (IOException e) {
            System.err.print(xmlFilePath + " is not valid because "
                    + e.getMessage());
        }
        return isDocumentValid;
    }
}