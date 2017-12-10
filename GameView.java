import java.util.*;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;


public class GameView {

    static String getOptionInput() {
        System.out.print("Do you want to guess a " + Colors.ANSI_GREEN + "l" + Colors.ANSI_RESET +
                         "etter or whole " + Colors.ANSI_RED + "w" + Colors.ANSI_RESET + "ord: ");
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
        System.out.println(Colors.ANSI_GREEN + "HANGMAN v.0.1" + Colors.ANSI_RESET);
        System.out.println(name);
        System.out.println(hint);
        System.out.println(Colors.ANSI_BLUE + "\nLives left: " + Colors.ANSI_RESET + lives);
    }

    static void display(String string) {
        System.out.println(string);
    }

    static void displayWinMessage() {
        System.out.print(Colors.ANSI_GREEN + "Congratulations! You win! " + Colors.ANSI_RESET);
    }

    static void displayLoseMessage() {
        System.out.print(Colors.ANSI_RED + "You lose! " + Colors.ANSI_RESET);
    }

    static void displayNotLetterMessage() {
        System.out.println(Colors.ANSI_RED + "It is not a letter!" + Colors.ANSI_RESET);
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

    static void displayWordError() {
        System.out.println("Please enter a word!");
    }

    static void displayLetterError() {
        System.out.println("Please enter a letter!");
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

    static void displayAsciiArt(int livesLeft) {
        if (livesLeft <= 10 && livesLeft > 8) {
            System.out.println(AsciiReader.readAscii(58, 68));
        } else if (livesLeft <= 8 && livesLeft > 6) {
            System.out.println(AsciiReader.readAscii(48, 57));
        } else if (livesLeft <= 6 && livesLeft > 4) {
            System.out.println(AsciiReader.readAscii(37, 46));
        } else if (livesLeft <= 4 && livesLeft > 2) {
            System.out.println(AsciiReader.readAscii(26, 35));
        } else if (livesLeft <= 2 && livesLeft > 0) {
            System.out.println(AsciiReader.readAscii(14, 23));
        } else {
            System.out.println(AsciiReader.readAscii(2, 11));
        }
    }

    public static void displayLeaderBoardEmpty() {
        System.out.println("Leaderboard is empty!");
    }
}
