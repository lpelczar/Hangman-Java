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

	public String getName() {
		return name;
	}

	public Date getDate() {
		return date;
	}

	public double getGuessingTime() {
		return guessingTime;
	}

	public int getGuessingTries() {
		return guessingTries;
	}

	public String getGuessedWord() {
		return guessedWord;
	}

}
