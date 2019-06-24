package NewXMLApproach;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;
import java.util.List;

@JacksonXmlRootElement(localName = "breakfast_menu")
public class BreakfastMenu {

    @JacksonXmlProperty(localName = "food")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Food> foodList = new ArrayList<>();

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    @Override
    public String toString() {
        return "BreakfastMenu{" +
                "foodList=" + foodList +
                '}';
    }

}
