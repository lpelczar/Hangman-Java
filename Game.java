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

        System.out.println(capital.getName());
        System.out.println(capital.getHiddenWordAsString());
        System.out.println(player.getLifePoints());
        String userOption = GameView.getOption();

        if (userOption == word) {
            guessWord();
        }
    }

    public void guessWord() {

        String word = GameView.getGuessedWord();
        if (capital.isWordEqualCapitalName(word)) {
            GameView.displayWinMessage();
        } else {
            player.decrementLifePoints();
            GameView.displayWrongWordMessage();
        }
    }


}
