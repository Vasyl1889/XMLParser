package com.myXMLParser.command;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Program ended.");
        System.exit(0);
    }
}
