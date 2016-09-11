package assignment1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by NickPierre on 9/11/16.
 */
public class EasyCalculatorGUI extends Application {
    private TextField tfNumber1 = new TextField();
    private TextField tfNumber2 = new TextField();
    private TextField tfResult = new TextField();


    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        gridPane.setPadding(new Insets(10, 10, 10, 10));


        tfNumber1.setMaxWidth(70);
        tfNumber2.setMaxWidth(70);
        tfResult.setMaxWidth(70);
        gridPane.add(new Label("Number 1: "), 0, 0);
        gridPane.add(tfNumber1, 1, 0);
        gridPane.add(new Label("Number 2: "), 2, 0);
        gridPane.add(tfNumber2, 3, 0);
        gridPane.add(new Label("Result: "), 4, 0);
        gridPane.add(tfResult, 5, 0);
        tfResult.setEditable(false);

        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.BOTTOM_CENTER);
        flowPane.setPadding(new Insets(10, 10, 10, 10));
        Button btAdd = new Button("Add");
        Button btSubtract = new Button("Subtract");
        Button btMultiply = new Button("Multiply");
        Button btDivide = new Button("Divide");
        flowPane.getChildren().addAll(btAdd, btSubtract, btMultiply, btDivide);

        btAdd.setOnAction(event -> addBttn());
        btSubtract.setOnAction(event -> subtractBttn());
        btDivide.setOnAction(event -> divideBttn());
        btMultiply.setOnAction(event -> multipleBttn());

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(gridPane);
        borderPane.setBottom(flowPane);

        Scene scene = new Scene(borderPane, 460, 100);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simple Calculator");
        primaryStage.show();
    }

    private void addBttn() {
        double number1 = Double.parseDouble(tfNumber1.getText());
        double number2 = Double.parseDouble(tfNumber2.getText());
        tfResult.setText(String.valueOf(number1 + number2));
    }
    private void subtractBttn() {
        double number1 = Double.parseDouble(tfNumber1.getText());
        double number2 = Double.parseDouble(tfNumber2.getText());
        tfResult.setText(String.valueOf(number1 - number2));
    }
    private void multipleBttn() {
        double number1 = Double.parseDouble(tfNumber1.getText());
        double number2 = Double.parseDouble(tfNumber2.getText());
        tfResult.setText(String.valueOf(number1 * number2));
    }
    private void divideBttn() {
        double number1 = Double.parseDouble(tfNumber1.getText());
        double number2 = Double.parseDouble(tfNumber2.getText());
        tfResult.setText(String.valueOf(number1 / number2));
    }
}
