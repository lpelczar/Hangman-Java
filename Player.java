class Player {

    private int lifePoints;
    private int guessingCount;
    private long startTime;
    private double guessingTime;

    public Player() {
        this.lifePoints = 5;
        this.guessingCount = 0;
        this.startTime = System.nanoTime();
    }

    public int getLifePoints() {
        if (this.lifePoints < 0) {
            this.lifePoints = 0;
        }
        return this.lifePoints;
    }

    public int getGuessingCount() {
        return this.guessingCount;
    }

    public double getGuessingTime() {
        return this.guessingTime;
    }

    public void decrementLifePointsByValue(int value) {
        this.lifePoints -= value;
    }

    public void incrementGuessingCount() {
        this.guessingCount++;
    }

    public void calculateTime() {
        long estimatedTime = System.nanoTime() - this.startTime;
        this.guessingTime = (double)estimatedTime / 1000000000.0;
    }
}
