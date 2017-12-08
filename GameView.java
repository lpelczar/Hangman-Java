import java.util.*;

class GameView {

    public static String getOptionInput() {
        System.out.print("Do you want to guess a letter or whole word (l or w): ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }
}
