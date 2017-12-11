import java.util.*;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;

/**
 * Display all information to the user in the console
 */
public class GameView {

    /**
     * Gets option from the user
     * @return option input
     */
    static String getOptionInput() {
        System.out.print("Do you want to guess a " + Colors.ANSI_GREEN + "l" + Colors.ANSI_RESET +
                         "etter or whole " + Colors.ANSI_RED + "w" + Colors.ANSI_RESET + "ord: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }

    /**
     * Gets guessed word from the user
     * @return guessed word
     */
    static String getGuessedWord() {
        System.out.print("Enter word: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }

    /**
     * Gets user name to add it to leaderboard
     * @return username
     */
    static String getUserName() {
        System.out.print("Enter your name to add your score to leaderboard: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }

    /**
     * Gets guessed letter from the user
     * @return guessed letter
     */
    static String getGuessedLetterInput() {
        System.out.print("Enter a letter: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }

    /**
     * Gets information if user wants to play again
     * @return information if user wants to play again
     */
    static String getPlayAgainInput() {
        System.out.print("Do you want to play again? (y or n) ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }

    /**
     * Displays hint and lives left to the user
     * @param hint word hidden with dashes
     * @param lives how many lives have left
     */
    static void displayHintAndLives(String hint, int lives) {
        System.out.println(Colors.ANSI_GREEN + "HANGMAN v.0.1" + Colors.ANSI_RESET);
        System.out.println(hint);
        System.out.println(Colors.ANSI_BLUE + "\nLives left: " + Colors.ANSI_RESET + lives);
    }

    /**
     * Displays notInWord message
     * @param notInWord letters not in word
     */
    static void displayNotInWord(String notInWord) {
        System.out.println("Not in word: " + notInWord);
    }

    /**
     * Displays win message to the user
     */
    static void displayWinMessage() {
        System.out.print(Colors.ANSI_GREEN + "Congratulations! You win! " + Colors.ANSI_RESET);
    }

    /**
     * Displays lose message to the user
     */
    static void displayLoseMessage() {
        System.out.print(Colors.ANSI_RED + "You lose! " + Colors.ANSI_RESET);
    }

    /**
     * Displays message that input is not a letter
     */
    static void displayNotLetterMessage() {
        System.out.println(Colors.ANSI_RED + "It is not a letter!" + Colors.ANSI_RESET);
    }

    /**
     * Displays message that letter is not in word
     */
    static void displayLetterNotInWordMessage() {
        System.out.println("Letter not in word! You lose 1 life point!");
        System.out.print("Press any key to continue.");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
    }

    /**
     * Displays message that guessed word is wrong
     */
    static void displayWrongWordMessage() {
        System.out.println("Wrong word! You lose 2 life point!");
        System.out.print("Press any key to continue.");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
    }

    /**
     * Displays message about wrong input
     */
    static void displayWrongInput() {
        System.out.println("Wrong input!");
    }

    /**
     * Displays given country name
     * @param country name of the country
     */
    static void displayCountryName(String country) {
        System.out.println("The capital of: " + country);
    }

    /**
     * Displays message that user have already guessed that letter
     */
    static void displayLetterAlreadyGuessed() {
        System.out.println("You have already guessed that letter!");
    }

    /**
     * Displays message if user enters nothing instead of word
     */
    static void displayWordError() {
        System.out.println("Please enter a word!");
    }

    /**
     * Displays message if user enters nothing instead of a letter
     */
    static void displayLetterError() {
        System.out.println("Please enter a letter!");
    }

    /**
     * Displays message about guessing time and tries
     * @param count how many tries
     * @param time how long the guessing took
     */
    static void displayGuessingCountAndTime(int count, double time) {
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("You tried: " + count + " letters. And game took you " + df.format(time) + " seconds.");
    }

    /**
     * Displays leaderboard
     * @param scores list of score objects
     */
    static void displayLeaderBoard(ArrayList<Score> scores) {

        final int MAX_HIGHSCORES_QUANTITY = 10;
        List<Score> shortenScores;

        if (scores.size() > MAX_HIGHSCORES_QUANTITY) {
            shortenScores = scores.subList(0, MAX_HIGHSCORES_QUANTITY);
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

    /**
     * Displays appropriate ascii art for given lives left
     * @param livesLeft how many lives is left
     */
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

    /**
     * Displays message that leaderboard is empty
     */
    public static void displayLeaderBoardEmpty() {
        System.out.println("Leaderboard is empty!");
    }
}
