import java.util.*;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;


public class GameView {

    static String getOptionInput() {
        System.out.print("Do you want to guess a letter or whole word (l or w): ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }

    static String getGuessedWord() {
        System.out.print("Enter word: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }

    static String getUserName() {
        System.out.print("Enter your name to add your score to leaderboard: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }

    static String getGuessedLetterInput() {
        System.out.print("Enter a letter: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }

    static String getPlayAgainInput() {
        System.out.print("Do you want to play again? (y or n) ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }

    static void displayHintAndLives(String name, String hint, int lives) {
        System.out.println(name);
        System.out.println(hint);
        System.out.println("Lives left: " + lives);
    }

    static void display(String string) {
        System.out.println(string);
    }

    static void displayWinMessage() {
        System.out.print("Congratulations! You win! ");
    }

    static void displayLoseMessage() {
        System.out.print("You lose! ");
    }

    static void displayNotLetterMessage() {
        System.out.println("It is not a letter!");
    }

    static void displayLetterNotInWordMessage() {
        System.out.println("Letter not in word! You lose 1 life point!");
        System.out.print("Press any key to continue.");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
    }

    static void displayWrongWordMessage() {
        System.out.println("Wrong word! You lose 2 life point!");
        System.out.print("Press any key to continue.");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
    }

    static void displayWrongInput() {
        System.out.println("Wrong input!");
    }

    static void displayCountryName(String country) {
        System.out.println("The capital of: " + country);
    }

    static void displayLetterAlreadyGuessed() {
        System.out.println("You have already guessed that letter!");
    }

    static void displayGuessingCountAndTime(int count, double time) {
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("You tried: " + count + " letters. And game took you " + df.format(time) + " seconds.");
    }

    static void displayLeaderBoard(ArrayList<Score> scores) {
        List<Score> shortenScores;

        if (scores.size() > 10) {
            shortenScores = scores.subList(0, 10);
        } else {
            shortenScores = scores;
        }
        if (scores.size() > 0) {
            System.out.println("\nLeaderboard (TOP 10): ");
            for (Score s : shortenScores) {
                System.out.println(s.getName() + " | " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(s.getDate())
                + " | " + s.getGuessingTime() + " | " + s.getGuessingTries() + " | " + s.getGuessedWord());
            }
        }
    }

    public static void displayLeaderBoardEmpty() {
        System.out.println("Leaderboard is empty!");
    }
}
