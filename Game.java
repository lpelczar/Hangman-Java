import java.util.*;

class Game {

    private Capital capital;
    private Player player;

    public Game() {

        this.capital = Capital.getRandomCapital();
        this.player = new Player();
    }

    public void start() {

        String word = "w";
        String letter = "l";

        System.out.println(capital.getName());
        System.out.println(capital.getHiddenWordAsString());
        System.out.println(player.getLifePoints());
        String userOption = getOption();

        if (userOption.equals(word)) {
            guessWord();
        }
    }

    public String getOption() {

        String[] correctOptions = {"l", "w"};
        String userInput = "";
        boolean userInputInCorrectOptions = false;

        while (!userInputInCorrectOptions) {
            userInput = GameView.getOptionInput();
            userInputInCorrectOptions = Arrays.asList(correctOptions).contains(userInput.toLowerCase());
        }
        return userInput;
    }

    public void guessWord() {

        String word = GameView.getGuessedWord();
        if (capital.isWordEqualCapitalName(word)) {
            GameView.displayWinMessage();
        } else {
            player.decrementLifePoints();
            GameView.displayWrongWordMessage();
        }
    }


}
