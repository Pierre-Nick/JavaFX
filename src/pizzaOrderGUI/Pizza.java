package pizzaOrderGUI;

import java.util.HashMap;

/**
 * Created by NickPierre on 11/7/16.
 */
public class Pizza {
    private int cheeseValue;
    private int size;
    private String name;
    private HashMap<Integer, String> toppings;
    private int cost;

    public Pizza() {
        cheeseValue = 1;
        size = 1;
        toppings = new HashMap<>();
        cost = 599;
        setName(size);
    }

    public Pizza(int cheeseValue, int size) {
        this.cheeseValue = cheeseValue;
        this.size = size;
        toppings = new HashMap<>();
        setName(this.size);
    }

    public void setName(int size) {
        switch (size) {
            case 0:
                this.name = "Small {Default} Pizza";
                break;
            case 1:
                this.name = "Medium {Default} Pizza";
                break;
            case 2:
                this.name = "Large {Default} Pizza";
                break;
            default:
                this.name = "Medium {Default} Pizza";
                break;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addTopping(String value, Integer key) {
        toppings.put(key, value);
    }

    public void removeTopping(Integer key) {
       toppings.remove(key);
    }
    public int getCheeseValue() {
        return cheeseValue;
    }

    public void setCheeseValue(int cheeseValue) {
        this.cheeseValue = cheeseValue;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Pizza{" +
            "cheeseValue=" + cheeseValue +
            ", size='" + size + '\'' +
            ", toppings=" + toppings +
            ", cost=" + cost +
            '}';
    }
}
