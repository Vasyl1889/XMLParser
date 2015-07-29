package com.myXMLParser.SAXparser;

import com.myXMLParser.candy.Candy;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class SAXParserClass {
    private List<Candy> candyList;

    public List<Candy> SAXParser(String filePath) {
        try {
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            SAXHandler saxHandler = new SAXHandler();
            if (saxHandler != null) {
                parser.parse(filePath, saxHandler);
                candyList = saxHandler.getCandyList();
            }
        } catch (ParserConfigurationException e) {
            System.err.println("Parser Config Error");
        } catch (IOException e) {
            System.err.println("Wrong Filepath");
        } catch (SAXException e) {
            System.err.println("SAXException");
        } catch (Exception e) {
            System.err.println("Exception");
        }
        return candyList;
    }
}
