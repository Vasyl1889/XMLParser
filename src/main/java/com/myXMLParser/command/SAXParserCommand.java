package com.myXMLParser.command;

import com.myXMLParser.SAXparser.SAXParserClass;
import com.myXMLParser.candy.Candies;
import com.myXMLParser.helper.ValidatorSAXXSD;

public class SAXParserCommand implements Command {
    @Override
    public void execute() {
        if (ValidatorSAXXSD.isXMLValid(XML_FILE_PATH, XSD_FILE_PATH)) {
            SAXParserClass saxParser = new SAXParserClass();
            Candies candies = new Candies();
            candies.setCandyList(saxParser.SAXParser(XML_FILE_PATH));
            candies.printCandyList();
        } else {
            System.out.println(XML_FILE_PATH + "is not valid.");
        }
    }
}
