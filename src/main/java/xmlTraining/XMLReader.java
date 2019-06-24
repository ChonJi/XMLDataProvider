package xmlTraining;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class XMLReader {

//    public static void main(String[] args) throws IOException {
//
//        File file = new File("K:\\!Programowanie\\XMLDataProvider\\src\\main\\java\\xmlTraining\\TestClass.xml");
//        XmlMapper xmlMapper = new XmlMapper();
//        String xml = inputStreamToString(new FileInputStream(file));
//        TestClass config = xmlMapper.readValue(xml, TestClass.class);
//        System.out.println(config.getId() + config.getParam());
//
//    }

    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new XmlMapper();
        TestClass tc = objectMapper.readValue(StringUtils.toEncodedString(Files.readAllBytes(Paths.get("TestClass.xml")), StandardCharsets.UTF_8),
                TestClass.class);
        System.out.println(tc);
        System.out.println(tc.getId() + tc.getParam());

    }

    public static String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }
}
