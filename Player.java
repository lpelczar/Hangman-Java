/**
 * Class containing player statistics
 */
class Player {

    private int lifePoints;
    private int guessingCount;
    private long startTime;
    private double guessingTime;

    /**
     * Constructor of the player
     */
    public Player() {
        this.lifePoints = 10;
        this.guessingCount = 0;
        this.startTime = System.nanoTime();
    }

    /**
     * Getter of the life points
     * @return life points left
     */
    public int getLifePoints() {
        return this.lifePoints;
    }

    /**
     * Getter of the guessing count
     * @return guessing count
     */
    public int getGuessingCount() {
        return this.guessingCount;
    }

    /**
     * Getter of the guessing time
     * @return guessing time
     */
    public double getGuessingTime() {
        return this.guessingTime;
    }

    /**
     * Decrements life points by given value
     * @param value how many points to subtract
     */
    public void decrementLifePointsByValue(int value) {
        if ((this.lifePoints - value) < 0) {
            this.lifePoints = 0;
        } else {
            this.lifePoints -= value;
        }
    }

    /**
     * Increments guessing count by one
     */
    public void incrementGuessingCount() {
        this.guessingCount++;
    }

    /**
     * Calculate time from creating a player to call this method
     */
    public void calculateTime() {
        long estimatedTime = System.nanoTime() - this.startTime;
        this.guessingTime = (double)estimatedTime / 1000000000.0;
    }
}
