import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Test {

    private String paramName;
    private String parameter;

    @XmlElement
    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public Test() {

    }

    public Test(String paramName) {
        this.paramName = paramName;
    }

    @XmlAttribute
    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

}
