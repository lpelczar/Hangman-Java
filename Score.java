import java.util.Date;
import java.io.Serializable;

/**
 * Represents single score
 */
class Score implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private Date date;
    private double guessingTime;
    private int guessingTries;
    private String guessedWord;

	/**
	 * Constructor of the score
	 * @param name name of the player
	 * @param date guessing date
	 * @param guessingTime guessing time
	 * @param guessingTries guessing tries
	 * @param guessedWord guessed word
	 */
    Score(String name, Date date, double guessingTime, int guessingTries, String guessedWord) {
        this.name = name;
        this.date = date;
        this.guessingTime = guessingTime;
        this.guessingTries = guessingTries;
        this.guessedWord = guessedWord;
    }

	/**
	 * Getter of the name
	 * @return name of the player
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter of the date
	 * @return guessing date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Getter of the guessing time
	 * @return guessing time
	 */
	public double getGuessingTime() {
		return guessingTime;
	}

	/**
	 * Getter of the guessing tries
	 * @return guessing tries
	 */
	public int getGuessingTries() {
		return guessingTries;
	}

	/**
	 * Getter of the guessed word
	 * @return guessed word
	 */
	public String getGuessedWord() {
		return guessedWord;
	}

}
