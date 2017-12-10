class Player {

    private int lifePoints;
    private int guessingCount;
    private long startTime;
    private double guessingTime;

    public Player() {
        this.lifePoints = 10;
        this.guessingCount = 0;
        this.startTime = System.nanoTime();
    }

    public int getLifePoints() {
        return this.lifePoints;
    }

    public int getGuessingCount() {
        return this.guessingCount;
    }

    public double getGuessingTime() {
        return this.guessingTime;
    }

    public void decrementLifePointsByValue(int value) {
        if ((this.lifePoints - value) < 0) {
            this.lifePoints = 0;
        } else {
            this.lifePoints -= value;
        }
    }

    public void incrementGuessingCount() {
        this.guessingCount++;
    }

    public void calculateTime() {
        long estimatedTime = System.nanoTime() - this.startTime;
        this.guessingTime = (double)estimatedTime / 1000000000.0;
    }
}
