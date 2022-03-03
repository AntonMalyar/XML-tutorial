import javax.xml.parsers.*;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class XML_tutorial_test {
    private static DocumentBuilderFactory factory;
    private static DocumentBuilder builder;
    private static Document document;
    
    @BeforeAll
    public static void preparation() throws ParserConfigurationException, IOException, SAXException {
        //Get Document Builder
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        //Build Document
        document = builder.parse(new File("C:\\Users\\fuckyou\\Desktop\\VS work space\\XML-tutorial\\src\\test\\resources\\test.xml"));
        //Normalize the XML Structure; It's just too important !!
        document.getDocumentElement().normalize();
    }
    @Test
    void testToGetRootElementOfDocument() {
        Element root = document.getDocumentElement();
        String rootElementName = root.getNodeName();
        Assertions.assertEquals("employees", rootElementName);
    }
    @Test
    void getAllChildNodods(){
        NodeList nodeList = document.getElementsByTagName("employee");
        String[] id = {"111","222","333"};
        for(int i = 0; i < nodeList.getLength(); i++){
            Node node = nodeList.item(i);
            Element element = (Element) node;
            Assertions.assertEquals(id[i], element.getAttribute("id"));

        }
    }
}
