package com.myXMLParser.main;

public enum Operation {
    DOMPARSER, SAXPARSER, STAXPARSER, VALIDATEXMLFILE, TRANSFORMTOHTML, MARSHALTONEWXML, EXIT;

    public static Operation getOperation(Integer i) {
        switch (i) {
            case 1:
                return Operation.DOMPARSER;
            case 2:
                return Operation.SAXPARSER;
            case 3:
                return Operation.STAXPARSER;
            case 4:
                return Operation.VALIDATEXMLFILE;
            case 5:
                return Operation.TRANSFORMTOHTML;
            case 6:
                return Operation.MARSHALTONEWXML;
            default:
                return Operation.EXIT;
        }
    }
}
