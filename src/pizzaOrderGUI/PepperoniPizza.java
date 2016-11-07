package pizzaOrderGUI;

/**
 * Created by NickPierre on 11/7/16.
 */
public class PepperoniPizza extends Pizza {
    private String name = "Pepperoni Pizza";
    public PepperoniPizza(int size) {
        super(2, size);
        super.setName(this.getSize());
        this.setName(this.getName().replace("{Default}", name));
    }
}
