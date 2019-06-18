import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

import static java.lang.String.valueOf;

public class XMLDataProvider {

@DataProvider(name = "xmlDataProvider")
public Object[][] dataProvider() {
    Object[][] objects = new Object[0][0];
    return objects;
}


public void readXML(String name) {

    try {
        File file = new File("K:\\!Programowanie\\XMLDataProvider\\src\\main\\resources\\TestContext.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(file);

        document.getDocumentElement().normalize();
        NodeList nodes = document.getElementsByTagName("parameter");
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            Element element = (Element) node;
            if(valueOf(element.getAttribute("name")).equals(name)) {
                System.out.println(element.getAttribute("value"));
            }

        }


    } catch (Exception e) {
        e.printStackTrace();
    }

}

    public static void main(String[] args) {
        XMLDataProvider xml = new XMLDataProvider();
        xml.readXML("testName");
    }

@Test(dataProvider = "xmlDataProvider")
public void testDataProvider() {
    Assert.assertSame(new Object[0][0], dataProvider());
}

}
