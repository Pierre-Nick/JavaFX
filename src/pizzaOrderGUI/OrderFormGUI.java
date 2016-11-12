package pizzaOrderGUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Created by NickPierre on 11/7/16.
 */
public class OrderFormGUI extends Application {

    private ComboBox<String> cbState = new ComboBox<>();
    private TextField tfFirstName = new TextField();
    private TextField tfLastName = new TextField();
    private TextField tfStreetAddress = new TextField();
    private TextField tfCity = new TextField();
    private TextField tfZipCode = new TextField();
    private TextField tfPhoneNumber = new TextField();
    private final ImageView pizzaImg = new ImageView(new Image("pizzaOrderGUI/pixxa2.png"));
    private final ImageView pizzaBanner = new ImageView(new Image("pizzaOrderGUI/Pizza-logos.png"));
    private final Button btnNext = new Button("Next");
    private final Button btnBack = new Button("Back");
    private Customer customer;

    @Override
    public void start(Stage primaryStage) {
        GridPane formViewGrid = new GridPane();
        setUpMainView(formViewGrid);

        cbState.getItems().addAll(
            "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN",
            "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV",
            "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN",
            "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY");

        btnNext.setOnAction(event -> {
            try {
                if (customer == null) {
                    createCustomer();
                    System.out.println(customer.toString());
                } else
                    System.out.println("Customer already created");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        btnBack.setOnAction(event -> reloadMainMenu());

        Scene scene = new Scene(formViewGrid, 500, 450);
        primaryStage.setScene(scene);
        primaryStage.setTitle("FAT FOOD");
        primaryStage.show();
    }

    private GridPane customerInfoView() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(5);
        gridPane.add(new Label("First Name"), 0, 0);
        gridPane.add(tfFirstName, 1, 0);
        gridPane.add(new Label("Last Name"), 0, 1);
        gridPane.add(tfLastName, 1, 1);
        gridPane.add(new Label("Street Address"), 0, 2);
        gridPane.add(tfStreetAddress, 1, 2);
        gridPane.add(new Label("City"), 0, 3);
        gridPane.add(tfCity, 1, 3);
        gridPane.add(new Label("State"), 0, 4);
        gridPane.add(cbState, 1, 4);
        gridPane.add(new Label("Zip Code"), 0 , 5);
        gridPane.add(tfZipCode, 1, 5);
        gridPane.add(new Label("Phone Number"),0, 6);
        gridPane.add(tfPhoneNumber, 1, 6);

        return gridPane;
    }

    private void setUpMainView(GridPane formViewGrid) {
        formViewGrid.setAlignment(Pos.CENTER);
        formViewGrid.setHgap(5);
        formViewGrid.setVgap(5);
        VBox formVBox = new VBox(customerInfoView());
        HBox bannerHBox = new HBox(pizzaBanner);
        bannerHBox.setAlignment(Pos.CENTER);
        HBox btnHBox = new HBox();
        btnHBox.setPadding(new Insets(5, 5, 5, 5));
        btnHBox.setSpacing(15);
        btnHBox.setAlignment(Pos.CENTER);
        btnHBox.getChildren().addAll(btnBack, btnNext);

        formVBox.setAlignment(Pos.CENTER);
        pizzaImg.setFitHeight(150);
        pizzaImg.setFitWidth(150);
        pizzaBanner.setFitWidth(250);
        pizzaBanner.setFitHeight(150);
        formViewGrid.addRow(0, bannerHBox);
        formViewGrid.add(formVBox, 0, 1);
        formViewGrid.addRow(2, btnHBox);
    }

    private void createCustomer() throws Exception {
        try {
            String name = tfFirstName.getText() + " " + tfLastName.getText();
            String address = tfStreetAddress.getText();
            String state = cbState.getId();
            String city = tfCity.getText();
            int zipcode = Integer.parseInt(tfZipCode.getText());
            String phoneNumber = tfPhoneNumber.getText();
            customer = new Customer(name, address, city, zipcode, state, phoneNumber);

        } catch (Exception ex) {
            throw new Exception("Attempted to create Object passing" +
                " 'null' data");
        }
    }

    private void reloadMainMenu() {

    }
}
