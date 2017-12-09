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
        boolean gameIsOver = false;

        while (!gameIsOver) {
            System.out.println(capital.getName());
            System.out.println(capital.getHint());
            System.out.println(player.getLifePoints());
            if (capital.getNotInWord().size() > 0) {
            System.out.println(capital.getNotInWordAsString());
            }
            String userOption = getOption();

            if (userOption.equals(word)) {
                gameIsOver = checkGuessedWord();
            } else if (userOption.equals(letter)) {
                gameIsOver = checkGuessedLetter();
            }

            if (player.getLifePoints() == 0) {
                GameView.displayLoseMessage();
                gameIsOver = true;
            }
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

    public boolean checkGuessedLetter() {

        boolean gameIsOver = false;
        char letter = getGuessedLetter();

        if (capital.getName().toUpperCase().contains(Character.toString(letter).toUpperCase())) {
            capital.unhideLetter(letter);

            if (capital.getHiddenWordAsString().equals(capital.getName())) {
                GameView.displayWinMessage();
                gameIsOver = true;
            }
        } else {
            GameView.displayLetterNotInWordMessage();
            capital.addLetterToNotInWord(Character.toString(letter).toUpperCase());
            player.decrementLifePoints();
        }

        return gameIsOver;
    }

    public static char getGuessedLetter() {

        boolean inputIsLetter = false;
        String userInput = "";

        while (!inputIsLetter) {

            userInput = GameView.getGuessedLetterInput();
            if (userInput.length() > 1 || !Character.isLetter(userInput.charAt(0))) {
                GameView.displayNotLetterMessage();
            } else {
            inputIsLetter = true;
            }
        }
        char letter = userInput.charAt(0);
        return letter;
    }

    public boolean checkGuessedWord() {

        boolean gameIsOver = false;
        String word = GameView.getGuessedWord();

        if (capital.isWordEqualCapitalName(word)) {
            GameView.displayWinMessage();
            gameIsOver = true;
        } else {
            player.decrementLifePoints();
            GameView.displayWrongWordMessage();
        }
        return gameIsOver;
    }

}
