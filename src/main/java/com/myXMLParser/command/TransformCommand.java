package com.myXMLParser.command;

import com.myXMLParser.helper.ValidatorSAXXSD;
import com.myXMLParser.transformer.TransformerClass;

public class TransformCommand implements Command {
    @Override
    public void execute() {
        if (ValidatorSAXXSD.isXMLValid(XML_FILE_PATH, XSD_FILE_PATH)) {
            TransformerClass.transformToHTML(XML_FILE_PATH, XSL_FILE_PATH);
        } else {
            System.out.println(XML_FILE_PATH + "is not valid.");
        }
    }
}
