import java.util.*;

class Game {

    private Capital capital;
    private Player player;

    public Game() {

        this.capital = Capital.getRandomCapital();
        this.player = new Player();
    }

    public void start() {
        System.out.println(capital.getName());
        System.out.println(Arrays.toString(capital.getHiddenWord()));
    }
}
