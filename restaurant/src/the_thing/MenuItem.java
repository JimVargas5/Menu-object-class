package the_thing;

import java.util.Date;

public class MenuItem {
    private static int nextItemId = 0;
    private String name;
    private Double price;
    private String description;
    private String category;
    private Date dateAdded = new Date();

    public MenuItem(int nextItemId, String name, Double price, String description, String category, Date dateAdded) {
        nextItemId = nextItemId;
        nextItemId++;
        name = name;
        price = price;
        description = description;
        category = category;
        dateAdded = dateAdded;
        //the_thing.Menu.setLastEditDate();
    }
    public MenuItem(String name, Double price, String description, String category){
        this(nextItemId, name, price, description, category, new Date());
    }
    //getters
    public String getName() {
        return name;
    }
    public Double getPrice() {
        return price;
    }
    public String getDescription() {
        return description;
    }
    public String getCategory() {
        return category;
    }
    public Date getDateAdded() {
        return dateAdded;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setCategory(String category) {
        this.category = category;
    }


}