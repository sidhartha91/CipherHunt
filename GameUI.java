import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

public class GameUI {

    private GameLogic gameLogic = new GameLogic();

    private Label messageLabel = new Label("Select difficulty to begin");
    private Label attemptsLabel = new Label("Attempts: 0");

    public Parent createContent() {

        VBox root = new VBox(20);
        root.setFillWidth(true);

        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(40));

        root.getStyleClass().add("background");

        VBox glassCard = new VBox(20);

        glassCard.setAlignment(Pos.CENTER);
        glassCard.getStyleClass().add("glass-card");

        Label title = new Label("Cipher Hunt");
        title.getStyleClass().add("title");

        Button easyButton = new Button("Easy");
        Button mediumButton = new Button("Medium");
        Button hardButton = new Button("Hard");

        HBox difficultyBox = new HBox(15);

        difficultyBox.setAlignment(Pos.CENTER);

        difficultyBox.getChildren().addAll(
                easyButton,
                mediumButton,
                hardButton
        );

        TextField guessField = new TextField();
        guessField.setMaxWidth(260);
        guessField.setPromptText("Enter your guess");

        Button investigateButton = new Button("Investigate");
        investigateButton.getStyleClass().add("investigate-button");

        easyButton.setOnAction(e -> {
            gameLogic.setDifficulty("Easy");
            messageLabel.setText("Easy mode selected");
        });

        mediumButton.setOnAction(e -> {
            gameLogic.setDifficulty("Medium");
            messageLabel.setText("Medium mode selected");
        });

        hardButton.setOnAction(e -> {
            gameLogic.setDifficulty("Hard");
            messageLabel.setText("Hard mode selected");
        });

        easyButton.getStyleClass().add("difficulty-button");
        mediumButton.getStyleClass().add("difficulty-button");
        hardButton.getStyleClass().add("difficulty-button");

        investigateButton.setOnAction(e -> {

            try {

                int guess = Integer.parseInt(guessField.getText());

                String result = gameLogic.checkGuess(guess);

                messageLabel.setText(result);

                attemptsLabel.setText(
                        "Attempts: " + gameLogic.getAttempts()
                );

                guessField.clear();

            }

            catch (Exception ex) {

                messageLabel.setText("Enter a valid number");
            }
        });

        Region spacer = new Region();
        spacer.setMinHeight(10);

        glassCard.getChildren().addAll(
                title,
                difficultyBox,
                spacer,
                guessField,
                investigateButton,
                attemptsLabel,
                messageLabel
        );

        root.getChildren().add(glassCard);

        messageLabel.setWrapText(true);
        attemptsLabel.getStyleClass().add("stats-label");
        messageLabel.getStyleClass().add("message-label");

        return root;
    }
}
