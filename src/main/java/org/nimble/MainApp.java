package org.nimble;

import utilities.PropertiesFileReader;
import utilities.TextFileReader;

/**
 * A Camel Application
 */
public class MainApp {

    /**
     * A main() so we can easily run these routing rules in our IDE
     */
    public static void main(String[] args) throws Exception {

        //Read file
        TextFileReader tfr = new TextFileReader();
        tfr.readFile("C:\\Joe\\FineRhino.com\\nimble\\reqs.txt");

        PropertiesFileReader pfr = new PropertiesFileReader();
        pfr.readProperties("C:\\Joe\\FineRhino.com\\nimble\\", "reqs.txt", "testOutput.docx");
    }

}

