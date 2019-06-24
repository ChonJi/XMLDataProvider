package NewXMLApproach;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Food {

    @JacksonXmlProperty(isAttribute = true)
    private String id;
    @JacksonXmlProperty(localName = "name")
    private String name;
    @JacksonXmlProperty(localName = "price")
    private String price;
    @JacksonXmlProperty(localName = "description")
    private String description;
    @JacksonXmlProperty(localName = "calories")
    private String calories;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                ", calories='" + calories + '\'' +
                '}';
    }

}
