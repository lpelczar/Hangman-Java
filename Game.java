import java.util.*;

/**
 * Controls the game loop
 */
class Game {

    private Capital capital;
    private Player player;
    private LeaderBoard leaderboard;

    /**
     * Constructor of the game
     */
    public Game() {

        this.capital = CapitalReader.getRandomCapital();
        this.player = new Player();
        this.leaderboard = new LeaderBoard();
    }

    /**
     * Starts the game loop and controls the game until the game is not over
     */
    public void start() {

        final String WORD = "w";
        final String LETTER = "l";
        final int LAST_LIFE = 1;
        boolean gameIsOver = false;
        double timeInSeconds;
        String userOption = "";

        while (!gameIsOver) {

            showGameHints();
            if (player.getLifePoints() == LAST_LIFE) {GameView.displayCountryName(capital.getCountry());}

            userOption = getOption();
            if (userOption.toLowerCase().equals(WORD)) {
                gameIsOver = checkGuessedWord();
            } else if (userOption.toLowerCase().equals(LETTER)) {
                gameIsOver = checkGuessedLetter();
            }

            if (player.getLifePoints() <= 0) {gameIsOver = true;}

            if (gameIsOver) {
                player.calculateTime();
                showGameHints();
                if (player.getLifePoints() <= 0) {
                    GameView.displayLoseMessage();
                } else {
                    GameView.displayWinMessage();
                    this.leaderboard.addScore(GameView.getUserName(), new Date(), player.getGuessingTime(),
                                             player.getGuessingCount(), capital.getName());
                }
                GameView.displayGuessingCountAndTime(player.getGuessingCount(), player.getGuessingTime());
                this.leaderboard.displayScores();
                gameIsOver = askToPlayAgain();
            }
        }
    }

    /**
     * Show all information for the user needed to play, eg. hints, lives, ascii art
     */
    private void showGameHints() {
        clearConsole();
        GameView.displayHintAndLives(capital.getHint(), player.getLifePoints());
        if (capital.getNotInWord().size() > 0) {
            GameView.displayNotInWord(capital.getNotInWordAsString());
        }
        GameView.displayAsciiArt(player.getLifePoints());
    }

    /**
     * Gets option from the user
     * @return user option "l" or "w" representing letter of word
     */
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

    /**
     * Checking if guessed letter is correct and update word, if not display appropriate message
     * @return true if all letters are guessed and the game is over else false
     */
    private boolean checkGuessedLetter() {

        final int LETTER_GUESSING_DECREMENT = 1;
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
            player.decrementLifePointsByValue(LETTER_GUESSING_DECREMENT);
        }

        return gameIsOver;
    }

    /**
     * Gets guessed letter from the user and check if it is actually a letter
     * @return letter
     */
    private char getGuessedLetter() {

        boolean correctInput = false;
        String userInput = "";

        while (!correctInput) {

            userInput = GameView.getGuessedLetterInput();
            if (userInput.length() == 0) {
                GameView.displayLetterError();
            } else if (userInput.length() > 1 || !Character.isLetter(userInput.charAt(0))) {
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

    /**
     * Checking if word given by user are correct
     * @return true if word is correct and false if not
     */
    private boolean checkGuessedWord() {

        final int WORD_GUESSING_DECREMENT = 2;
        boolean gameIsOver = false;
        boolean isWordCorrect = false;
        String word = "";

        while (!isWordCorrect) {
            word = GameView.getGuessedWord();
            if (word.length() == 0) {
                GameView.displayWordError();
            } else {
                isWordCorrect = true;
            }
        }

        if (capital.isWordEqualCapitalName(word)) {
            capital.makeHiddenWordEqualWord();
            gameIsOver = true;
        } else {
            player.decrementLifePointsByValue(WORD_GUESSING_DECREMENT);
            if (!(player.getLifePoints() <= 0)) {
                GameView.displayWrongWordMessage();
            }
        }
        return gameIsOver;
    }

    /**
     * Asks user if he wants to play again
     * @return true if not and false if yes
     */
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
            this.capital = CapitalReader.getRandomCapital();
            this.player = new Player();
        } else {
            gameIsOver = true;
        }
        return gameIsOver;
    }

    /**
     * Clears the console
     */
    private static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
