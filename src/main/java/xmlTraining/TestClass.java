package xmlTraining;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "testclass")
public class TestClass {

    @JacksonXmlProperty(localName = "param")
    private String param;
    @JacksonXmlProperty(localName = "id")
    private String id;

    public TestClass() {
    }

    public TestClass(String param, String id) {
        this.param = param;
        this.id = id;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "id='" + id + '\'' +
                ", param='" + param + '\'' +
                '}';
    }

}
