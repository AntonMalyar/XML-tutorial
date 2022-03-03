import javax.xml.parsers.*;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class XML_tutorial_test {
    @BeforeAll
    public void preparation() throws ParserConfigurationException, IOException, SAXException {
        //Get Document Builder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        //Build Document
        Document document = builder.parse(new File("test.xml"));
        //Normalize the XML Structure; It's just too important !!
        document.getDocumentElement().normalize();
        System.out.print("preparation");

    }
    
}
