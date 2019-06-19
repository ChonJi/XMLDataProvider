import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class Tests {

    private String testName;
    private ArrayList<Test> tests;

    public Tests(){

    }

    public Tests(ArrayList<Test> tests) {
        this.tests = tests;
    }

    @XmlElement
    public ArrayList<Test> getTests() {
        return tests;
    }

    @XmlAttribute
    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public void setTests(ArrayList<Test> test) {
        this.tests = test;
    }

}
