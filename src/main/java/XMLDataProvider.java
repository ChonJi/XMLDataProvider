import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

public class XMLDataProvider {

    private Document document;

    public XMLDataProvider(String xmlFile) {

        try {
            ClassLoader loader = XMLDataProvider.class.getClassLoader();
            File file = new File(loader.getResource(xmlFile).getFile());
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public String getValue(String name) {

        NodeList nodes = document.getElementsByTagName("parameter");
        String value = null;

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            Element element = (Element) node;
            if(valueOf(element.getAttribute("name")).equals(name)) {
               value = element.getAttribute("value");
            }
        }
        return value;
    }

    public List<String> getValues(String name) {

        NodeList nodes = document.getElementsByTagName("parameter");
        List<String> values = new ArrayList<String>();

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            Element element = (Element) node;
            if(valueOf(element.getAttribute("name")).equals(name)) {
                values.add(element.getAttribute("value"));
            }
        }
        return values;
    }

    public static void main(String[] args) {
        XMLDataProvider xml = new XMLDataProvider("TestContext.xml");
        System.out.println(xml.getValue("testName"));
        System.out.println(xml.getValues("testName2"));
    }

@Test(dataProvider = "xmlDataProvider")
public void testDataProvider() {

}

}
