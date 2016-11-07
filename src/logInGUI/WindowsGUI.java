package logInGUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Locale;

/**
 * Created by Nick Pierre on 8/21/2016.
 */
public class WindowsGUI extends Application {
    private String gender;
    private TextField tfFirstName = new TextField();
    private TextField tfLastName = new TextField();
    private PasswordField passwordField = new PasswordField();
    private PasswordField confirmField = new PasswordField();
    private TextArea taResultField = new TextArea();
    private DatePicker dobPicker = new DatePicker();
    private Button btSubmit = new Button("Submit");

    @Override
    public void start(Stage primaryStage) {
        Locale.setDefault(Locale.US);
        Scene scene = new Scene(initUI(), 450, 420); // blaze-it lol
        primaryStage.setScene(scene);
        primaryStage.setTitle("Nick Pierre - Window's GUI");
        primaryStage.show();
    }

    private BorderPane initUI() {
        // Main Pane
        BorderPane borderPane = new BorderPane();
        //Some default stuff
        passwordField.setPromptText("Enter Password");
        taResultField.setEditable(false);
        // Our GridPane section which goes on top section of borderPane
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(5, 5, 5, 5));
        gridPane.add(new Label("First Name: "), 0, 0);
        gridPane.add(tfFirstName, 1, 0);
        gridPane.add(new Label("Last Name:" ), 0, 1);
        gridPane.add(tfLastName, 1, 1);
        gridPane.add(new Label("DOB: "), 0, 3);
        gridPane.add(dobPicker, 1, 3);
        gridPane.add(new Label("Password: "), 0, 4);
        gridPane.add(passwordField, 1, 4);
        gridPane.add(new Label("Re-enter Password: "), 0, 5);
        gridPane.add(confirmField, 1, 5);
        gridPane.add(btSubmit, 3, 6);

        // HBox Contained within the GridPane for genders
        HBox genders = new HBox(10);
        RadioButton[] radioButtons = new RadioButton[3];
        radioButtons[0] = new RadioButton("Male");
        radioButtons[1] = new RadioButton("Female");
        radioButtons[2] = new RadioButton("Other");
        ToggleGroup rbGroup = new ToggleGroup();

        for (RadioButton r : radioButtons) {
            r.setToggleGroup(rbGroup);
            genders.getChildren().add(r);
        }

        // Event Handlers for RadioButtons
        radioButtons[0].setOnAction(event -> {
            if (radioButtons[0].isSelected()) {
                gender = "Male";
            }
        });
        radioButtons[1].setOnAction(event -> {
            if (radioButtons[1].isSelected()) {
                gender = "Female";
            }
        });
        radioButtons[2].setOnAction(event -> {
            if (radioButtons[2].isSelected()) {
                gender = "Other";
            }
        });

        gridPane.add(new Label("Gender: "), 0, 2);
        gridPane.add(genders, 1, 2);

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().add(taResultField);
        taResultField.setStyle(" -fx-font-size: 10px; -fx-font-weight: bold; -fx-text-alignment: center");

        btSubmit.setOnAction(event -> setTextArea());
        borderPane.setTop(gridPane);
        borderPane.setCenter(hBox);
        return borderPane;
    }

    private void setTextArea() {
        if (!checkPassword(passwordField.getText())) {
            taResultField.setText("INVALID PASSWORD FIELD");
        } else if (!passwordField.getText().equals(confirmField.getText())) {
            taResultField.setText("PASSWORDS DO NOT MATCH");
        }else {
            User user = new User(gender, tfFirstName.getText(), tfLastName.getText(), dobPicker);
            taResultField.setText(user.toString() + "\n\n****REGISTRATION COMPLETE****");
        }
    }

    private boolean checkPassword(String password) {
        boolean digit = false, lowerC = false, upperC = false, symbol = false;

        if (password.length() >= 8) {
            char[] pass = password.toCharArray();
            for (char p : pass) {
                if (Character.isDigit(p)) {
                    digit = true;
                } else if (!Character.isDigit(p) && !Character.isAlphabetic(p)) {
                    symbol = true;
                } else if (Character.isUpperCase(p)) {
                    upperC = true;
                } else if (Character.isLowerCase(p)) {
                    lowerC = true;
                } else {
                    return false;
                }
            }
        }

        return (digit && lowerC && upperC && symbol);
    }
}
