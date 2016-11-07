package emailGUI;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Properties;
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
    private final Label notiflbl = new Label("Invalid Credentials!");
    /* Button Declarations/Init */
    private final Button signInBtn = new Button("Sign-In");
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
    private final TextArea taMessage = new TextArea();
    /* Fade-In Transitions */
    private final FadeTransition fadeIn = new FadeTransition(new Duration(3000));

    @Override
    public void start(Stage primaryStage) {
        mainlbl.setPadding(new Insets(10));
        VBox titleVBox = new VBox(mainlbl);
        titleVBox.setAlignment(Pos.CENTER);
        titleVBox.getChildren().add(notiflbl);
        notiflbl.setVisible(false);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(titleVBox);
        borderPane.setCenter(signInWindow());


        Scene scene = new Scene(borderPane, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("PoPo Mail Client");
        primaryStage.show();

        signInBtn.setOnAction(event -> {
            if (credentialsCheck()) {
                notiflbl.setVisible(false);
                stageResize(primaryStage);
                sendEmailWindow(borderPane);
            } else {
                notiflbl.setTextFill(Color.RED);
                notiflbl.setVisible(true);
            }
        });
        sendBtn.setOnAction(event -> sendEmail());
        closeBtn.setOnAction(event -> {
            Platform.exit();
            System.exit(0);
        });
    }

    /**
     * Generates the default sign-in window
     * @return
     */
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

        HBox buttonHBox = new HBox();
        buttonHBox.setAlignment(Pos.CENTER);
        buttonHBox.setSpacing(20);
        buttonHBox.getChildren().addAll(signInBtn, closeBtn);

        return new VBox(15, guiGridPane, buttonHBox);
    }

    /**
     * Takes in a borderPane as an argument.
     * Clears the borderPane of its' contents and
     * generates the email client.
     * @param borderPane
     */
    private void sendEmailWindow(BorderPane borderPane) {
        tfFrom.setText(tfEmail.getText());
        tfFrom.setEditable(false);
        borderPane.getChildren().clear();

        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(tolbl, 0, 0);
        gridPane.add(tfTo, 1, 0);
        gridPane.add(fromlbl, 0, 1);
        gridPane.add(tfFrom, 1, 1);
        gridPane.add(subjectlbl, 0, 2);
        gridPane.add(tfSubject, 1, 2);
        gridPane.add(messagelbl, 0, 4);
        taMessage.setWrapText(true);
        gridPane.add(taMessage, 1, 4);

        HBox buttonHBox = new HBox();
        buttonHBox.setPadding(new Insets(10, 10, 10, 10));
        buttonHBox.setAlignment(Pos.CENTER);
        buttonHBox.setSpacing(20);
        buttonHBox.getChildren().addAll(sendBtn, closeBtn, helpBtn);

        VBox titleVBox = new VBox(mainlbl);
        titleVBox.getChildren().add(notiflbl);
        titleVBox.setAlignment(Pos.CENTER);
        borderPane.setVisible(false);
        borderPane.setTop(titleVBox);
        borderPane.setCenter(gridPane);
        borderPane.setBottom(buttonHBox);
        fadeIn.setNode(borderPane);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.setCycleCount(1);
        fadeIn.setAutoReverse(false);
        borderPane.setVisible(true);
        fadeIn.playFromStart();
    }

    /**
     * Validates credentials from initial stage prior to moving on
     * a valid email is at least 7 characters long as it must include '@', '.', '.com or .org or .net etc.'
     * along with text prior to the @ symbol and after it.
     *
     * @return: 'True' if all fields are valid.
     */
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

    /**
     * For this method to work you need to have the mail.jar and activation.jar
     * for the javamail api to work!
     */
    private void sendEmail() {
        String to = tfTo.getText();
        String from = tfFrom.getText();
        String host = "localhost";
        Properties properties = System.getProperties();

        properties.setProperty("mail.smtp.host", host);
        //Session session = Session.getDefaultInstace(properties);

        try {
          /*  MIMEMessage message = new MIMEMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            message.setSubject(tfSubject.getText());
            message.setText(taMessage.getText());

            Transport.send(message); */
          if (to.length() > 6) {
              notiflbl.setText("Message Sent Successfully!");
              notiflbl.setTextFill(Color.GREEN);
          } else {
              notiflbl.setText("Error Message Was Not Sent");
              notiflbl.setTextFill(Color.RED);
          }
            notiflbl.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * A stage is resized to display all of
     * it's new elements in the email view
     * @param stage
     */
    private void stageResize(Stage stage) {
        Timer windowResizeTimer = new Timer();
        windowResizeTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (stage.getHeight() <= 500) {
                    stage.setHeight(stage.getHeight()+5);
                    if (stage.getWidth() <= 600)
                        stage.setWidth(stage.getWidth()+10);
                } else {
                    this.cancel();
                }
            }
        }, 500, 25);
    }

}

