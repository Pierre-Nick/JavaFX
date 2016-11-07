package pizzaOrderGUI;

/**
 * Created by NickPierre on 11/7/16.
 */
public class CheesePizza extends Pizza {
    private String name = "Cheese Pizza";
    public CheesePizza(int size) {
        super(2, size);
        super.setName(this.getSize());
        this.setName(this.getName().replace("{Default}", name));
    }
}
