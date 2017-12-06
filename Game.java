class Game {

    Capital capital;
    Player player;

    public Game(Capital capital, Player player) {
        this.capital = Capital.getRandomCapital();
        this.player = new Player();
    }
}
