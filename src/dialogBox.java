import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by NickPierre on 9/26/16.
 */
public class dialogBox extends Application {
    @Override
    public void start(Stage primaryStage) {

        BorderPane pane = new BorderPane();
        HBox textField = new HBox();
        textField.setAlignment(Pos.CENTER);
        Label lblDialog = new Label("Would you like to enable this virus?");
        textField.getChildren().add(lblDialog);
        textField.setMargin(lblDialog, new Insets(15, 10, 0, 10));
        HBox buttonPane = new HBox(15);
        buttonPane.setAlignment(Pos.CENTER);
        Button btnYes = new Button("Yes");
        Button btnNo = new Button("No");

        buttonPane.getChildren().addAll(btnYes, btnNo);

        pane.setTop(textField);
        pane.setCenter(buttonPane);

        Scene scene = new Scene(pane,300,100);
        primaryStage.setScene(scene);
        primaryStage.setTitle("\t\tCustom Dialog Box");
        primaryStage.show();

    }
}
