import java.util.*;
import java.text.DecimalFormat;

class GameView {

    public static String getOptionInput() {
        System.out.print("Do you want to guess a letter or whole word (l or w): ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }

    public static String getGuessedWord() {
        System.out.print("Enter word: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }

    public static String getUserName() {
        System.out.print("Enter your name to add your score to leaderboard: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }

    public static String getGuessedLetterInput() {
        System.out.print("Enter a letter: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }

    public static String getPlayAgainInput() {
        System.out.print("Do you want to play again? (y or n) ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }

    public static void displayHintAndLives(String name, String hint, int lives) {
        System.out.println(name);
        System.out.println(hint);
        System.out.println("Lives left: " + lives);
    }

    public static void display(String string) {
        System.out.println(string);
    }

    public static void displayWinMessage() {
        System.out.print("Congratulations! You win! ");
    }

    public static void displayLoseMessage() {
        System.out.print("You lose! ");
    }

    public static void displayNotLetterMessage() {
        System.out.println("It is not a letter!");
    }

    public static void displayLetterNotInWordMessage() {
        System.out.println("Letter not in word! You lose 1 life point!");
        System.out.print("Press any key to continue.");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
    }

    public static void displayWrongWordMessage() {
        System.out.println("Wrong word! You lose 2 life point!");
        System.out.print("Press any key to continue.");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
    }

    public static void displayWrongInput() {
        System.out.println("Wrong input!");
    }

    public static void displayCountryName(String country) {
        System.out.println("The capital of: " + country);
    }

    public static void displayLetterAlreadyGuessed() {
        System.out.println("You have already guessed that letter!");
    }

    public static void displayGuessingCountAndTime(int count, double time) {
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("You tried: " + count + " letters. And game took you " + df.format(time) + " seconds.");
    }

    public static void displayLeaderBoard(ArrayList<Score> scores) {
        if (scores.size() > 0) {
            System.out.println("\nLeaderboard: ");
            for (Score s : scores) {
                System.out.println(s.getName() + " | " + s.getDate() + " | " + s.getGuessingTime() + " | " +
                                   s.getGuessingTries() + " | " + s.getGuessedWord());
            }
        }
    }

    public static void displayLeaderBoardEmpty() {
        System.out.println("Leaderboard is empty!");
    }
}
