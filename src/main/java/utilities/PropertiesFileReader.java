package utilities;

import org.docx4j.jaxb.Context;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.exceptions.InvalidFormatException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.ObjectFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Joseph on 5/6/2017.
 */
public class PropertiesFileReader {

    public void readProperties(String pn, String fn, String outfn) {
        Properties properties = new Properties();
        FileInputStream in = null;
        try {
            in = new FileInputStream(pn+fn);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(properties.getProperty("h"));
        System.out.println(properties.getProperty("ht"));
        System.out.println(properties.getProperty("s1h"));
        System.out.println(properties.getProperty("s1t"));

        //Create a New Doc
        // Create the package
        WordprocessingMLPackage wordMLPackage = new WordprocessingMLPackage();
        try {
            wordMLPackage = WordprocessingMLPackage.createPackage();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        // Create the main document part (word/document.xml)
        MainDocumentPart wordDocumentPart = null;
        try {
            wordDocumentPart = new MainDocumentPart();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        // Create main document part content
        ObjectFactory factory = Context.getWmlObjectFactory();
        org.docx4j.wml.Body body = factory .createBody();
        org.docx4j.wml.Document wmlDocumentEl = factory.createDocument();
        wmlDocumentEl.setBody(body);

        // Put the content in the part
        wordDocumentPart.setJaxbElement(wmlDocumentEl);

        // Add the main document part to the package relationships
        // (creating it if necessary)
        //wmlPack.addTargetPart(wordDocumentPart);

        // Save it
        try {
            wordMLPackage.save(new java.io.File(pn,outfn));
        } catch (Docx4JException e) {
            e.printStackTrace();
        }

    }
}
