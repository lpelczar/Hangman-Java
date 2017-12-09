import java.util.*;

class Game {

    private Capital capital;
    private Player player;
    private LeaderBoard leaderboard;

    public Game() {

        this.capital = Capital.getRandomCapital();
        this.player = new Player();
        this.leaderboard = new LeaderBoard();
    }

    public void start() {

        final String WORD = "w";
        final String LETTER = "l";
        boolean gameIsOver = false;
        double timeInSeconds;
        String userOption = "";

        while (!gameIsOver) {

            showGameHints(capital.getName(), capital.getHint(), player.getLifePoints(), capital.getNotInWordAsString());

            if (player.getLifePoints() == 1) {GameView.displayCountryName(capital.getCountry());}

            userOption = getOption();
            if (userOption.toLowerCase().equals(WORD)) {
                gameIsOver = checkGuessedWord();
            } else if (userOption.toLowerCase().equals(LETTER)) {
                gameIsOver = checkGuessedLetter();
            }

            if (player.getLifePoints() <= 0) {gameIsOver = true;}

            if (gameIsOver) {
                player.calculateTime();
                showGameHints(capital.getName(), capital.getHint(),
                              player.getLifePoints(),capital.getNotInWordAsString());
                if (player.getLifePoints() <= 0) {
                    GameView.displayLoseMessage();
                } else {
                    GameView.displayWinMessage();
                }
                GameView.displayGuessingCountAndTime(player.getGuessingCount(), player.getGuessingTime());
                this.leaderboard.displayScores();
                gameIsOver = askToPlayAgain();
            }
        }
    }

    private void showGameHints(String capitalName, String hint, int lives, String notInWord) {
        clearConsole();
        GameView.displayHintAndLives(capitalName, hint, lives);
        if (capital.getNotInWord().size() > 0) {
            GameView.display(notInWord);
        }
    }

    private String getOption() {

        final String[] CORRECT_OPTIONS = {"l", "w"};
        String userInput = "";
        boolean userInputInCorrectOptions = false;

        while (!userInputInCorrectOptions) {
            userInput = GameView.getOptionInput();
            userInputInCorrectOptions = Arrays.asList(CORRECT_OPTIONS).contains(userInput.toLowerCase());
            if (!userInputInCorrectOptions) {
                GameView.displayWrongInput();
            }
        }
        return userInput;
    }

    private boolean checkGuessedLetter() {

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

    private char getGuessedLetter() {

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

    private boolean checkGuessedWord() {

        final int WORD = 2;
        boolean gameIsOver = false;
        String word = GameView.getGuessedWord();

        if (capital.isWordEqualCapitalName(word)) {
            capital.makeHiddenWordEqualWord();
            gameIsOver = true;
        } else {
            player.decrementLifePointsByValue(WORD);
            if (!(player.getLifePoints() <= 0)) {
                GameView.displayWrongWordMessage();
            }
        }
        return gameIsOver;
    }

    private boolean askToPlayAgain() {

        boolean gameIsOver;
        String[] CORRECT_OPTIONS = {"y", "n"};
        String userInput = "";
        boolean userInputInCorrectOptions = false;

        while (!userInputInCorrectOptions) {
            userInput = GameView.getPlayAgainInput();
            userInputInCorrectOptions = Arrays.asList(CORRECT_OPTIONS).contains(userInput.toLowerCase());
            if (!userInputInCorrectOptions) {
                GameView.displayWrongInput();
            }
        }

        if (userInput.toLowerCase().equals(CORRECT_OPTIONS[0])) {
            gameIsOver = false;
            this.capital = Capital.getRandomCapital();
            this.player = new Player();
        } else {
            gameIsOver = true;
        }
        return gameIsOver;
    }

    private static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
