import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Very simple class to demonstrate JavaFX with a button
 */
public class TestJavaFX extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hi out there");
        Button button = new Button();
        button.setText("Hello World");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World to the entire world!");
            }
        });

        // Using lambdas to create a shadow when mouse is over the button.
        DropShadow shadow = new DropShadow();
        button.addEventHandler(MouseEvent.MOUSE_EXITED, e -> button.setEffect(null));
        button.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> button.setEffect(shadow));


        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(button);
        borderPane.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                System.out.println("Hmm, you have to click the button");

            }
        });
        primaryStage.setScene(new Scene(borderPane, 200, 150));
        primaryStage.show();
    }
}