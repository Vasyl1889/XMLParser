package com.myXMLParser.main;

import com.myXMLParser.command.CommandExecutor;
import com.myXMLParser.helper.ConsoleHelper;

public class Main {
    public static void main(String[] args) {
        Operation operation;
        do {
            ConsoleHelper.showMenu();
            operation = Operation.getOperation(ConsoleHelper.getChoice());
            CommandExecutor.execute(operation);
        } while (!(operation.equals(Operation.EXIT)));
    }
}
