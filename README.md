# Documentation

# `class Application`

Top class which starts the Application.

## `public static void main(String[] args)`

Main method of the program - initialize Game and call start method on it.

 * **Parameters:** `args`

# `class AsciiReader`

Reads txt file and returns string containing lines from startline to endline.

## `public static String readAscii(int startLine, int endLine)`

Read file with Ascii arts and return Ascii art from startline to endline as a String.

 * **Parameters:**
   * `startLine` — start line of ascii art in a file
   * `endLine` — end line of ascii art in a file
 * **Returns:** Ascii art

# `class Capital`

Represents Capital word to guess

## `public Capital(String name, String country)`

Constructor of the Capital

 * **Parameters:**
   * `name` — name of the capital
   * `country` — country of the capital

## `public String getName()`

Getter of name

 * **Returns:** name of the capital

## `public String getCountry()`

Getter of the country

 * **Returns:** name of the country

## `public String[] getHiddenWord()`

Getter of the hidden word

 * **Returns:** word respresented with dashes as a String array

## `public ArrayList<String> getNotInWord()`

Getter of notInWord hint

 * **Returns:** hint with guessed letters which are not in guessing word

## `public ArrayList<String> getAlreadyGuessed()`

Getter of alreadyGuessed letters

 * **Returns:** already guessed letters

## `public String getNotInWordAsString()`

Get notInWord as a String

 * **Returns:** notIsWord as a String

## `public String getHiddenWordAsString()`

Get hidden word as a String

 * **Returns:** hidden word as a String

## `public String getHint()`

Get hint from hiddenWord

 * **Returns:** hiddenWord as a String

## `public boolean isWordEqualCapitalName(String word)`

Chceck if word is equal capital name

 * **Parameters:** `word` — entered word by the user
 * **Returns:** true if is equal else false

## `public void makeHiddenWordEqualWord()`

Reveal hidden word to the user - change hiddenWord variable to capital name

## `public void addLetterToNotInWord(String letter)`

Adds letter to notInWord array

 * **Parameters:** `letter` — letter given by user

## `public void addLetterToAlreadyGuessed(String letter)`

Adds letter to alreadyGuessed array

 * **Parameters:** `letter` — letter given by the user

## `public void unhideLetter(char letter)`

Unhide given letter in hiddenWord

 * **Parameters:** `letter` — letter given by the user

# `class CapitalReader`

Class for reading capitals from file and creating Capital objects from them

## `public static Capital getRandomCapital()`

Returns random Capital object from list of capitals

 * **Returns:** random Capital

## `private static ArrayList<Capital> getCapitalsFromFile()`

Read file with capitals and create a list containing all Capital objects

 * **Returns:** list of capital objects

# `public class Colors`

Class containing Ansi codes for coloring text in console

# `class Game`

Controls the game loop

## `public Game()`

Constructor of the game

## `public void start()`

Starts the game loop and controls the game until the game is not over

## `private void showGameHints()`

Show all information for the user needed to play, eg. hints, lives, ascii art

## `private String getOption()`

Gets option from the user

 * **Returns:** user option "l" or "w" representing letter of word

## `private boolean checkGuessedLetter()`

Checking if guessed letter is correct and update word, if not display appropriate message

 * **Returns:** true if all letters are guessed and the game is over else false

## `private char getGuessedLetter()`

Gets guessed letter from the user and check if it is actually a letter

 * **Returns:** letter

## `private boolean checkGuessedWord()`

Checking if word given by user are correct

 * **Returns:** true if word is correct and false if not

## `private boolean askToPlayAgain()`

Asks user if he wants to play again

 * **Returns:** true if not and false if yes

## `private static void clearConsole()`

Clears the console

# `public class GameView`

Display all information to the user in the console

## `static String getOptionInput()`

Gets option from the user

 * **Returns:** option input

## `static String getGuessedWord()`

Gets guessed word from the user

 * **Returns:** guessed word

## `static String getUserName()`

Gets user name to add it to leaderboard

 * **Returns:** username

## `static String getGuessedLetterInput()`

Gets guessed letter from the user

 * **Returns:** guessed letter

## `static String getPlayAgainInput()`

Gets information if user wants to play again

 * **Returns:** information if user wants to play again

## `static void displayHintAndLives(String hint, int lives)`

Displays hint and lives left to the user

 * **Parameters:**
   * `hint` — word hidden with dashes
   * `lives` — how many lives have left

## `static void displayNotInWord(String notInWord)`

Displays notInWord message

 * **Parameters:** `notInWord` — letters not in word

## `static void displayWinMessage()`

Displays win message to the user

## `static void displayLoseMessage()`

Displays lose message to the user

## `static void displayNotLetterMessage()`

Displays message that input is not a letter

## `static void displayLetterNotInWordMessage()`

Displays message that letter is not in word

## `static void displayWrongWordMessage()`

Displays message that guessed word is wrong

## `static void displayWrongInput()`

Displays message about wrong input

## `static void displayCountryName(String country)`

Displays given country name

 * **Parameters:** `country` — name of the country

## `static void displayLetterAlreadyGuessed()`

Displays message that user have already guessed that letter

## `static void displayWordError()`

Displays message if user enters nothing instead of word

## `static void displayLetterError()`

Displays message if user enters nothing instead of a letter

## `static void displayGuessingCountAndTime(int count, double time)`

Displays message about guessing time and tries

 * **Parameters:**
   * `count` — how many tries
   * `time` — how long the guessing took

## `static void displayLeaderBoard(ArrayList<Score> scores)`

Displays leaderboard

 * **Parameters:** `scores` — list of score objects

## `static void displayAsciiArt(int livesLeft)`

Displays appropriate ascii art for given lives left

 * **Parameters:** `livesLeft` — how many lives is left

## `public static void displayLeaderBoardEmpty()`

Displays message that leaderboard is empty

# `class LeaderBoard`

Class containing list of Score objects

## `LeaderBoard()`

Constructor of the class

## `public void addScore(String name, Date date, double guessingTime, int guessingTries, String guessedWord)`

Adds score to the scores list

 * **Parameters:**
   * `name` — name of the user
   * `date` — date of the play
   * `guessingTime` — guessing time
   * `guessingTries` — guessing tries
   * `guessedWord` — guessed word

## `private void sortScores()`

Sort scores by guessing time

## `public void displayScores()`

Display scores to the user

## `private void serializeScores()`

Save whole list of scores to file (serialize it)

## `@SuppressWarnings("unchecked") private void deserializeScores()`

Get whole list of scores from file

# `class Player`

Class containing player statistics

## `public Player()`

Constructor of the player

## `public int getLifePoints()`

Getter of the life points

 * **Returns:** life points left

## `public int getGuessingCount()`

Getter of the guessing count

 * **Returns:** guessing count

## `public double getGuessingTime()`

Getter of the guessing time

 * **Returns:** guessing time

## `public void decrementLifePointsByValue(int value)`

Decrements life points by given value

 * **Parameters:** `value` — how many points to subtract

## `public void incrementGuessingCount()`

Increments guessing count by one

## `public void calculateTime()`

Calculate time from creating a player to call this method

# `class Score implements Serializable`

Represents single score

## `Score(String name, Date date, double guessingTime, int guessingTries, String guessedWord)`

Constructor of the score

 * **Parameters:**
   * `name` — name of the player
   * `date` — guessing date
   * `guessingTime` — guessing time
   * `guessingTries` — guessing tries
   * `guessedWord` — guessed word

## `public String getName()`

Getter of the name

 * **Returns:** name of the player

## `public Date getDate()`

Getter of the date

 * **Returns:** guessing date

## `public double getGuessingTime()`

Getter of the guessing time

 * **Returns:** guessing time

## `public int getGuessingTries()`

Getter of the guessing tries

 * **Returns:** guessing tries

## `public String getGuessedWord()`

Getter of the guessed word

 * **Returns:** guessed word
