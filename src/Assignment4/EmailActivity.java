package Assignment4;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by NickPierre on 10/24/16.
 */
public class EmailActivity extends Application {
    private final Label mainlbl = new Label("PoPo Mail");
    /* Sign-In Window */
    private final Label firstNamelbl = new Label("First Name");
    private final Label lastNamelbl = new Label("Last Name");
    private final Label emaillbl = new Label("Email Address");
    /* Messaging Window */
    private final Label tolbl = new Label("To");
    private final Label fromlbl = new Label("From");
    private final Label subjectlbl = new Label("Subject");
    private final Label messagelbl = new Label("Message");
    private final Label attachmentlbl = new Label("Attachment");
    private final Label incorrectlbl = new Label("Invalid Credentials!");
    /* Button Declarations/Init */
    private final Button signInBtn = new Button("Sign-In");
    private final Button forgetPassBtn = new Button("Forgot-Password");
    private final Button sendBtn = new Button("Send");
    private final Button closeBtn = new Button("Close");
    private final Button helpBtn = new Button("Help");
    /* TextField Declarations/Init */
    private final TextField tfFirstName = new TextField();
    private final TextField tfLastName = new TextField();
    private final TextField tfEmail = new TextField();
    private final TextField tfTo = new TextField();
    private final TextField tfFrom = new TextField();
    private final TextField tfSubject = new TextField();
    /* Fade-In Transitions */
    private final FadeTransition fadeInSlow = new FadeTransition(new Duration(6000));
    private final FadeTransition fadeIn = new FadeTransition(new Duration(3000));
    private final FadeTransition fadeInFast = new FadeTransition(new Duration(1000));

    @Override
    public void start(Stage primaryStage) {
        mainlbl.setPadding(new Insets(10));
        VBox titleVbox = new VBox(mainlbl);
        titleVbox.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(titleVbox);
        borderPane.setCenter(signInWindow());


        Scene scene = new Scene(borderPane, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("PoPo Mail Client");
        primaryStage.show();

        signInBtn.setOnAction(event -> {
            if (credentialsCheck()) {
                sendEmailWindow(borderPane);
                stageResize(primaryStage);
            } else {
                titleVbox.getChildren().add(incorrectlbl);
                incorrectlbl.setTextFill(Color.RED);
            }
        });
    }

    private VBox signInWindow() {
        GridPane guiGridPane = new GridPane();
        guiGridPane.setAlignment(Pos.CENTER);
        guiGridPane.setVgap(5);
        guiGridPane.setHgap(10);
        guiGridPane.add(firstNamelbl, 0, 0);
        guiGridPane.add(tfFirstName, 1, 0);
        guiGridPane.add(lastNamelbl, 0, 1);
        guiGridPane.add(tfLastName, 1, 1);
        guiGridPane.add(emaillbl, 0, 2);
        guiGridPane.add(tfEmail, 1, 2);

        HBox buttonHbox = new HBox();
        buttonHbox.setAlignment(Pos.CENTER);
        buttonHbox.setSpacing(20);
        buttonHbox.getChildren().addAll(signInBtn, forgetPassBtn);

        return new VBox(15, guiGridPane, buttonHbox);
    }

    private VBox sendEmailWindow(BorderPane borderPane) {
        borderPane.getChildren().clear();
        return new VBox();
    }

    private boolean credentialsCheck() {
        boolean validEmail, validFirstName, validLastName;
        String emailPattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@" +
            "((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])" +
            "|(([a-zA-Z\\-0-9]+\\.)[a-zA-Z]{2,3}))$";
        java.util.regex.Pattern mailPattern = java.util.regex.Pattern.compile(emailPattern);
        java.util.regex.Pattern namePattern = java.util.regex.Pattern.compile("[a-zA-Z]{2,}");

        java.util.regex.Matcher userEmailMatcher = mailPattern.matcher(tfEmail.getText());
        java.util.regex.Matcher userName = namePattern.matcher(tfFirstName.getText());
        validEmail = userEmailMatcher.matches();
        validFirstName = userName.matches();
        userName = namePattern.matcher(tfLastName.getText());
        validLastName = userName.matches();

        return (validEmail && validFirstName && validLastName);
    }

    private void stageResize(Stage stage) {
        Timer windowResizeTimer = new Timer();
        windowResizeTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (stage.getHeight() <= 500) {
                    stage.setHeight(stage.getHeight()+5);
                } else if (stage.getWidth() <= 500) {
                    stage.setWidth(stage.getWidth()+10);
                } else {
                    this.cancel();
                }
            }
        }, 500, 25);
    }

}

