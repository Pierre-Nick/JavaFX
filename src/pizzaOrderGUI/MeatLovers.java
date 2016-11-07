package pizzaOrderGUI;

/**
 * Created by NickPierre on 11/7/16.
 */
public class MeatLovers extends Pizza {
    private String name = "Meat Lovers Pizza";
    public MeatLovers(int size) {
        super(2, size);
        super.setName(this.getSize());
        this.setName(this.getName().replace("{Default}", name));
    }
}
