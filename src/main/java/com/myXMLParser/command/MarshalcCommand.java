package com.myXMLParser.command;

import com.myXMLParser.helper.ValidatorSAXXSD;
import com.myXMLParser.marshal.MarshalClass;

public class MarshalcCommand implements Command {

    @Override
    public void execute() {
        if (ValidatorSAXXSD.isXMLValid(XML_FILE_PATH, XSD_FILE_PATH)) {
            MarshalClass.marshalToNewXML(XML_FILE_PATH);
        } else {
            System.out.println(XML_FILE_PATH + "is not valid.");
        }
    }
}
