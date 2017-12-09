import java.util.*;

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

    public static void displayWinMessage() {
        System.out.println("Congratulations! You win!");
    }

    public static void displayWrongWordMessage() {
        System.out.println("Wrong word! You lose 1 life point!");
    }

    public static void displayLoseMessage() {
        System.out.println("You lose!");
    }

    public static void displayNotLetterMessage() {
        System.out.println("It is not a letter!");
    }

    public static void displayLetterNotInWordMessage() {
        System.out.println("Letter not in word! You lose 1 life point!");
    }


}
