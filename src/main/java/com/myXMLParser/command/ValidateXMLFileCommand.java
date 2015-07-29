package com.myXMLParser.command;

import com.myXMLParser.helper.ValidatorSAXXSD;

import java.io.File;

public class ValidateXMLFileCommand implements Command {
    @Override
    public void execute() {
        File file = new File(XML_FILE_PATH);
        if (ValidatorSAXXSD.isXMLValid(XML_FILE_PATH, XSD_FILE_PATH)) {
            System.out.println(file.getName() + " is valid.");
        } else {
            System.out.println(file.getName() + " is not valid.");
        }
    }
}
