package NewXMLApproach;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;

public class Reader {

    private File xmlFile;

    public Reader(String xmlFile) {
        this.xmlFile = new File(String.valueOf(xmlFile));
    }

    private BreakfastMenu read() throws IOException {
        try {
            File file = xmlFile;
            XmlMapper xmlMapper = new XmlMapper();
            String xml = inputStreamToString(new FileInputStream(file));
            BreakfastMenu breakfastMenu = xmlMapper.readValue(xml, BreakfastMenu.class);
            return breakfastMenu;

        } catch (IOException e) {
            throw e;
        }
    }

    private final String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }

    public String getNodeChildren(String foodId) throws IOException {
        if (read().getFoodList().get(0).getId().equals(foodId)) {
            return read().getFoodList().get(0).getName(); //etc...
        } else return "";
    }

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader("menu.xml");
        System.out.println(reader.getNodeChildren("SimpleDescription"));
    }

}
