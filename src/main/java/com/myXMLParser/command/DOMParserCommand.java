package com.myXMLParser.command;

import com.myXMLParser.DOMparser.DOMParserClass;
import com.myXMLParser.candy.Candies;
import com.myXMLParser.helper.ValidatorSAXXSD;

public class DOMParserCommand implements Command {
    @Override
    public void execute() {
        if (ValidatorSAXXSD.isXMLValid(XML_FILE_PATH, XSD_FILE_PATH)) {
            DOMParserClass domParser = new DOMParserClass();
            Candies candies = new Candies();
            candies.setCandyList(domParser.DOMParser(XML_FILE_PATH));
            candies.printCandyList();
        } else {
            System.out.println(XML_FILE_PATH + "is not valid.");
        }
    }
}
