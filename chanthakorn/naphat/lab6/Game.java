package chanthakorn.naphat.lab6;

abstract class Game {
    protected String gameName;
    protected int numOfPlayers;

    public String getGameName() {
        return gameName;
    }

    public void setGameName() {
        this.gameName = gameName;
    }

    public int getNumOfPlayers() {
        return numOfPlayers;
    }

    public void setNumOfPlayers() {
        this.numOfPlayers = numOfPlayers;
    }

    public Game() {
        this.gameName = "unknown game";
        this.numOfPlayers = 0;
    }

    public Game(String gameName, int numOfPlayers) {
        this.gameName = gameName;
        this.numOfPlayers = numOfPlayers;
    }

    @Override
    public String toString() {
        return "{ gameName='" + gameName + "', numOfPlayers='" + numOfPlayers + "'}";
    }

    abstract void playGame();
}