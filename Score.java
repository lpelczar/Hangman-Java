import java.util.Date;
import java.io.Serializable;

class Score implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private Date date;
    private double guessingTime;
    private int guessingTries;
    private String guessedWord;

    Score(String name, Date date, double guessingTime, int guessingTries, String guessedWord) {
        this.name = name;
        this.date = date;
        this.guessingTime = guessingTime;
        this.guessingTries = guessingTries;
        this.guessedWord = guessedWord;
    }

	/**
	* Returns value of name
	* @return
	*/
	public String getName() {
		return name;
	}

	/**
	* Returns value of date
	* @return
	*/
	public Date getDate() {
		return date;
	}

	/**
	* Returns value of guessingTime
	* @return
	*/
	public double getGuessingTime() {
		return guessingTime;
	}

	/**
	* Returns value of guessingTries
	* @return
	*/
	public int getGuessingTries() {
		return guessingTries;
	}

	/**
	* Returns value of guessedWord
	* @return
	*/
	public String getGuessedWord() {
		return guessedWord;
	}

}
