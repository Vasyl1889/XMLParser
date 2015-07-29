package com.myXMLParser.command;

public interface Command {
    String XML_FILE_PATH = "./src/main/resource/Candy.xml";
    String XSD_FILE_PATH = "./src/main/resource/Candy.xsd";
    String XSL_FILE_PATH = "./src/main/resource/Candy.xsl";

    public void execute();
}
