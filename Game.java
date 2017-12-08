class Game {

    Capital capital;
    Player player;
    LeaderBoard leaderboard;

    public Game() {
        
        this.capital = Capital.getRandomCapital();
        this.player = new Player();
        this.leaderboard = new LeaderBoard();

    }
}
