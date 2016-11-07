package pizzaOrderGUI;

/**
 * Created by NickPierre on 11/7/16.
 */
public class SausagePizza extends Pizza {
    private String name = "Sausage Pizza";
    public SausagePizza(int size) {
        super(2, size);
        super.setName(this.getSize());
        this.setName(this.getName().replace("{Default}", name));
    }
}
