package com.myXMLParser.command;

import com.myXMLParser.StAXparser.StAXParserClass;
import com.myXMLParser.candy.Candies;
import com.myXMLParser.helper.ValidatorSAXXSD;

public class StAXParserCommand implements Command {
    @Override
    public void execute() {
        if (ValidatorSAXXSD.isXMLValid(XML_FILE_PATH, XSD_FILE_PATH)) {
            StAXParserClass staxParser = new StAXParserClass();
            Candies candies = new Candies();
            candies.setCandyList(staxParser.StAXParser(XML_FILE_PATH));
            candies.printCandyList();
        } else {
            System.out.println(XML_FILE_PATH + "is not valid.");
        }
    }
}
