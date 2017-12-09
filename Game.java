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
        long estimatedTime;

        while (!gameIsOver) {

            showGameHints(capital.getName(), capital.getHint(), player.getLifePoints(),
                                  capital.getNotInWordAsString());

            if (player.getLifePoints() == 1) {
                GameView.displayCountryName(capital.getCountry());
            }

            String userOption = getOption();
            if (userOption.toLowerCase().equals(word)) {
                gameIsOver = checkGuessedWord();
            } else if (userOption.toLowerCase().equals(letter)) {
                gameIsOver = checkGuessedLetter();
            }

            if (player.getLifePoints() == 0) {
                gameIsOver = true;
            }

            if (gameIsOver) {
                estimatedTime = System.nanoTime() - player.getStartTime();
                showGameHints(capital.getName(), capital.getHint(), player.getLifePoints(),
                                      capital.getNotInWordAsString());
                if (player.getLifePoints() == 0) {
                    GameView.displayLoseMessage();
                } else {
                    GameView.displayWinMessage();
                }
                GameView.displayGuessingCountAndTime(player.getGuessingCount(), estimatedTime);
                gameIsOver = askToPlayAgain();
            }
        }
    }

    public void showGameHints(String capitalName, String hint, int lives, String notInWord) {
        clearConsole();
        GameView.displayHintAndLives(capitalName, hint, lives);
        if (capital.getNotInWord().size() > 0) {
            GameView.display(notInWord);
        }
    }

    public String getOption() {

        String[] correctOptions = {"l", "w"};
        String userInput = "";
        boolean userInputInCorrectOptions = false;

        while (!userInputInCorrectOptions) {
            userInput = GameView.getOptionInput();
            userInputInCorrectOptions = Arrays.asList(correctOptions).contains(userInput.toLowerCase());
            if (!userInputInCorrectOptions) {
                GameView.displayWrongInput();
            }
        }
        return userInput;
    }

    public boolean checkGuessedLetter() {

        final int LETTER = 1;
        boolean gameIsOver = false;
        char letter = getGuessedLetter();

        player.incrementGuessingCount();
        if (capital.getName().toUpperCase().contains(Character.toString(letter).toUpperCase())) {
            capital.unhideLetter(letter);

            if (capital.getHiddenWordAsString().equals(capital.getName())) {
                gameIsOver = true;
            }
        } else {
            GameView.displayLetterNotInWordMessage();
            capital.addLetterToNotInWord(Character.toString(letter).toUpperCase());
            player.decrementLifePointsByValue(LETTER);
        }

        return gameIsOver;
    }

    public char getGuessedLetter() {

        boolean correctInput = false;
        String userInput = "";

        while (!correctInput) {

            userInput = GameView.getGuessedLetterInput();
            if (userInput.length() > 1 || !Character.isLetter(userInput.charAt(0))) {
                GameView.displayNotLetterMessage();
            } else if (capital.getAlreadyGuessed().contains(userInput.toUpperCase())) {
                GameView.displayLetterAlreadyGuessed();
            } else {
            correctInput = true;
            }
        }

        capital.addLetterToAlreadyGuessed(userInput.toUpperCase());
        char letter = userInput.charAt(0);
        return letter;
    }

    public boolean checkGuessedWord() {

        final int WORD = 2;
        boolean gameIsOver = false;
        String word = GameView.getGuessedWord();

        if (capital.isWordEqualCapitalName(word)) {
            capital.makeHiddenWordEqualWord();
            gameIsOver = true;
        } else {
            player.decrementLifePointsByValue(WORD);
            GameView.displayWrongWordMessage();
        }
        return gameIsOver;
    }

    public boolean askToPlayAgain() {

        boolean gameIsOver;
        String[] correctOptions = {"y", "n"};
        String userInput = "";
        boolean userInputInCorrectOptions = false;

        while (!userInputInCorrectOptions) {
            userInput = GameView.getPlayAgainInput();
            userInputInCorrectOptions = Arrays.asList(correctOptions).contains(userInput.toLowerCase());
            if (!userInputInCorrectOptions) {
                GameView.displayWrongInput();
            }
        }

        if (userInput.toLowerCase().equals(correctOptions[0])) {
            gameIsOver = false;
            this.capital = Capital.getRandomCapital();
            this.player = new Player();
        } else {
            gameIsOver = true;
        }
        return gameIsOver;
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
