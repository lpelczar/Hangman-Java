import java.util.*;
import java.io.*;
import java.lang.ClassNotFoundException;

/**
 * Class containing list of Score objects
 */
class LeaderBoard {

    private ArrayList<Score> scores = new ArrayList<Score>();

    /**
     * Constructor of the class
     */
    LeaderBoard() {
        deserializeScores();
    }

    /**
     * Adds score to the scores list
     * @param name name of the user
     * @param date date of the play
     * @param guessingTime guessing time
     * @param guessingTries guessing tries
     * @param guessedWord guessed word
     */
    public void addScore(String name, Date date, double guessingTime, int guessingTries, String guessedWord) {
        this.scores.add(new Score(name, date, guessingTime, guessingTries, guessedWord));
        serializeScores();
    }

    /**
     * Sort scores by guessing time
     */
    private void sortScores() {
        this.scores.sort(Comparator.comparing(Score::getGuessingTime));
    }

    /**
     * Display scores to the user
     */
    public void displayScores() {
        deserializeScores();
        sortScores();
        GameView.displayLeaderBoard(this.scores);
    }

    /**
     * Save whole list of scores to file (serialize it)
     */
    private void serializeScores() {

        try {
			// write object to file
			FileOutputStream fos = new FileOutputStream("scores.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this.scores);
			oos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    /**
     * Get whole list of scores from file
     */
    @SuppressWarnings("unchecked")
    private void deserializeScores() {

        try {
			// read object from file
			FileInputStream fis = new FileInputStream("scores.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			this.scores = (ArrayList<Score>) ois.readObject();
			ois.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
            GameView.displayLeaderBoardEmpty();
        } catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }



}
