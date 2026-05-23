import java.util.Random;

public class GameLogic {

    private int randomNumber;
    private int attempts;
    private int maxNumber;

    public void setDifficulty(String difficulty) {

        if (difficulty.equals("Easy")) {
            maxNumber = 50;
        }

        else if (difficulty.equals("Medium")) {
            maxNumber = 100;
        }

        else {
            maxNumber = 200;
        }

        randomNumber = new Random().nextInt(maxNumber) + 1;

        attempts = 0;
    }

    public String checkGuess(int guess) {

        attempts++;

        if (guess == randomNumber) {
            return "Cipher cracked successfully.";
        }

        else if (guess > randomNumber) {
            return "Cipher value is lower.";
        }

        else {
            return "Cipher value is higher.";
        }
    }

    public int getAttempts() {
        return attempts;
    }
}
