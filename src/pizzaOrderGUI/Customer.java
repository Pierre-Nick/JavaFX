package pizzaOrderGUI;

/**
 * Created by NickPierre on 11/7/16.
 */
public class Customer {
    private String name;
    private String address;
    private String city;
    private String state;
    private String phoneNumber;
    private Pizza customerOrder;
    private static int customerOrderNumber = 0;
    private int zipcode;

    public Customer(String name, String address, String city, int zipcode, String state, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.zipcode = zipcode;
        this.state = state;
        this.phoneNumber = phoneNumber;
        customerOrderNumber++;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getZipcode() {
        return zipcode;
    }

    public static int getCustomerOrderNumber() {
        return customerOrderNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
            "name='" + name + '\'' +
            ", address='" + address + '\'' +
            ", city='" + city + '\'' +
            ", state='" + state + '\'' +
            ", phoneNumber='" + phoneNumber + '\'' +
            ", zipcode=" + zipcode +
            '}';
    }
}
