import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        GameUI gameUI = new GameUI();

        Scene scene = new Scene(gameUI.createContent(), 500, 600);

        scene.getStylesheets().add("style.css");

        stage.setTitle("Cipher Hunt");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
