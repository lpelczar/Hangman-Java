class Player {

    private int lifePoints;
    private int guessingCount;

    public Player() {
        this.lifePoints = 10;
        this.guessingCount = 0;
    }

    public int getLifePoints() {
        return this.lifePoints;
    }

    public int getGuessingCount() {
        return this.guessingCount;
    }

    public void decrementLifePoints() {
        this.lifePoints--;
    }

    public void incrementGuessingCount() {
        this.guessingCount++;
    }
}
