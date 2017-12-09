class Player {

    private int lifePoints;
    private int guessingCount;
    private long startTime;

    public Player() {
        this.lifePoints = 5;
        this.guessingCount = 0;
        this.startTime = System.nanoTime();
    }

    public long getStartTime() {
        return this.startTime;
    }

    public int getLifePoints() {
        return this.lifePoints;
    }

    public int getGuessingCount() {
        return this.guessingCount;
    }

    public void decrementLifePointsByValue(int value) {
        this.lifePoints -= value;
    }

    public void incrementGuessingCount() {
        this.guessingCount++;
    }
}
