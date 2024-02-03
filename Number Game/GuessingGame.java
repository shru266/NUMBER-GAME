import javax.swing.*;

public class GuessingGame {

    private static final int MAX_ATTEMPTS = 6;

    public static void main(String[] args) {
        boolean playAgain;

        do {
            playAgain = playRound();
        } while (playAgain);

        JOptionPane.showMessageDialog(null, "Thanks for playing!");
    }

    public static boolean playRound() {
        int computerNumber = (int) (Math.random() * 100 + 1);
        int userAnswer = 0;
        int count = 1;

        while (userAnswer != computerNumber && count <= MAX_ATTEMPTS) {
            String response = JOptionPane.showInputDialog(null,
                    "Enter a guess between 1 and 100", "Guessing Game", 3);
            userAnswer = Integer.parseInt(response);

            JOptionPane.showMessageDialog(null, determineGuess(userAnswer, computerNumber, count));

            if (userAnswer == computerNumber) {
                JOptionPane.showMessageDialog(null, "Correct!\nTotal Guesses: " + count);
                break;
            }

            count++;
        }

        if (userAnswer != computerNumber) {
            JOptionPane.showMessageDialog(null, "Sorry, you've reached the maximum number of attempts. The correct number was: " + computerNumber);
        }

        int option = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Play Again", JOptionPane.YES_NO_OPTION);
        return option == JOptionPane.YES_OPTION;
    }

    public static String determineGuess(int userAnswer, int computerNumber, int count) {
        if (userAnswer <= 0 || userAnswer > 100) {
            return "Your guess is invalid";
        } else if (userAnswer == computerNumber) {
            return "Correct!\nTotal Guesses: " + count;
        } else if (userAnswer > computerNumber) {
            return "Your guess is too high, try again.\nAttempt Number: " + count;
        } else {
            return "Your guess is too low, try again.\nAttempt Number: " + count;
        }
    }
}
