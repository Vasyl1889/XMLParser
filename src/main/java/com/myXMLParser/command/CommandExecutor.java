package com.myXMLParser.command;

import com.myXMLParser.main.Operation;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {
    private static Map<Operation, Command> commandMap = new HashMap<>();

    static {
        commandMap.put(Operation.DOMPARSER, new DOMParserCommand());
        commandMap.put(Operation.SAXPARSER, new SAXParserCommand());
        commandMap.put(Operation.STAXPARSER, new StAXParserCommand());
        commandMap.put(Operation.VALIDATEXMLFILE, new ValidateXMLFileCommand());
        commandMap.put(Operation.TRANSFORMTOHTML, new TransformCommand());
        commandMap.put(Operation.MARSHALTONEWXML, new MarshalcCommand());
        commandMap.put(Operation.EXIT, new ExitCommand());
    }

    public static final void execute(Operation operation) {
        commandMap.get(operation).execute();
    }
}
