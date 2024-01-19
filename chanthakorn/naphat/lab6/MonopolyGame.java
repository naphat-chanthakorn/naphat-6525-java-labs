package chanthakorn.naphat.lab6;

public class MonopolyGame extends Game {
    protected String[] gamePieces;

    public String[] getGamePieces() {
        return gamePieces;
    }

    public void setGamePieces(String[] gamePieces) {
        this.gamePieces = gamePieces;
    }

    public MonopolyGame() {
        super("Monopoly Game", 4);
        this.gamePieces = new String[] { "car", "top hat", "thimble", "boot" };
    }

    public MonopolyGame(String[] gamePieces) {
        super("Monopoly Game", 4);
        this.gamePieces = gamePieces;
    }

    @Override
    public void playGame() {
        System.out.println("Playing Monopoly Game");
    }

    @Override
    public String toString() {
        return super.toString() + " { game pieces='" + gamePieces[0] + " " + gamePieces[1] + " " + gamePieces[2] + " "
                + gamePieces[3] + " '}";
    }
}
