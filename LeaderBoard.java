import java.util.*;
import java.io.*;
import java.lang.ClassNotFoundException;

class LeaderBoard {

    private ArrayList<Score> scores = new ArrayList<Score>();

    LeaderBoard() {
        deserializeScores();
    }

    public void addScore(String name, Date date, double guessingTime, int guessingTries, String guessedWord) {
        this.scores.add(new Score(name, date, guessingTime, guessingTries, guessedWord));
        serializeScores();
    }

    private void sortScores() {
        this.scores.sort(Comparator.comparing(Score::getGuessingTime));
    }

    public void displayScores() {
        deserializeScores();
        sortScores();
        GameView.displayLeaderBoard(this.scores);
    }

    public void serializeScores() {

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

    public void deserializeScores() {

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
