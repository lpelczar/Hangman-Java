class Player {

    int lifePoints;

    public Player() {
        this.lifePoints = 10;
    }

    public int getLifePoints() {
        return this.lifePoints;
    }

    public void decrementLifePoints() {
        this.lifePoints--;
    }

}
