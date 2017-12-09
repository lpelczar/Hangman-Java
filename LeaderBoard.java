import java.util.*;

class LeaderBoard {

    private ArrayList<Score> scores = new ArrayList<Score>();

    LeaderBoard() {}

    public void addScore(String name, Date date, double guessingTime, int guessingTries, String guessedWord) {
        this.scores.add(new Score(name, date, guessingTime, guessingTries, guessedWord));
    }

    private void sortScores() {
        this.scores.sort(Comparator.comparing(Score::getGuessingTime));
    }

    public void displayScores() {
        sortScores();
        GameView.displayLeaderBoard(this.scores);
    }
}
