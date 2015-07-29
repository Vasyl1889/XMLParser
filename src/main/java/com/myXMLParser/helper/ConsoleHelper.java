package com.myXMLParser.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(
            new InputStreamReader(System.in));

    private static String readString() throws IOException {
        return bufferedReader.readLine();
    }

    public static int getChoice() {
        int number = 0;
        while (true) {
            try {
                String inputLine = readString();
                number = Integer.valueOf(inputLine.trim());

                if (0 < number && number <= 7) {
                    break;
                } else {
                    System.out
                            .println("Wrong Data. Please input RIGHT number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong Data. Please input INTEGER number.");
            } catch (IOException e) {
                System.out.println("Wrong Data. Please input INTEGER number.");
            }
        }
        return number;
    }

    public static void showMenu() {
        System.out
                .println("-----------------------------------------------------");
        System.out
                .println("| Please choise operation.                          |\n"
                        + "-----------------------------------------------------\n"
                        + "| Pasre XML file using DOMParser        | press - 1 |\n"
                        + "| Pasre XML file using SAXParser        | press - 2 |\n"
                        + "| Pasre XML file using StAXParser       | press - 3 |\n"
                        + "| Check is XML file valid               | press - 4 |\n"
                        + "| Transform XML to HTML using XSL       | press - 5 |\n"
                        + "| Create new XML                        | press - 6 |\n"
                        + "| Exit program                          | press - 7 |");
        System.out
                .println("-----------------------------------------------------");
    }
}
