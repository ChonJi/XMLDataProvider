import javax.xml.bind.*;
import java.io.File;

public class TestMain {

    public static void main(String[] args) {
        ClassLoader loader = XMLDataProvider.class.getClassLoader();
        File file = new File(loader.getResource("TestContext.xml").getFile());

        try {
            JAXBContext context = JAXBContext.newInstance(Tests.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Tests tests = (Tests) unmarshaller.unmarshal(file);
            System.out.println(tests.getTests().get(0));


        } catch (JAXBException e) {
            e.printStackTrace();
        }




    }

}
