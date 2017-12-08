import java.util.*;

class GameView {

    public static String getOption() {

        String[] correctOptions = {"l", "w"};
        String userInput = "";
        boolean userInputInCorrectOptions = false;

        while (!userInputInCorrectOptions) {
            System.out.print("Do you want to guess a letter or whole word (l or w): ");
            Scanner scanner = new Scanner(System.in);
            userInput = scanner.nextLine();
            userInputInCorrectOptions = Arrays.asList(correctOptions).contains(userInput.toLowerCase());
        }
        return userInput;
    }
}
