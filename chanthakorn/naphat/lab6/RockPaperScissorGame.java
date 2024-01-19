package chanthakorn.naphat.lab6;

public class RockPaperScissorGame extends Game {
    protected String player1choice, player2choice;

    public String getPlayer1choice() {
        return player1choice;
    }

    public void setPlayer1choice(String player1choice) {
        this.player1choice = player1choice;
    }

    public String getPlayer2choice() {
        return player2choice;
    }

    public void setPlayer2choice(String player2choice) {
        this.player2choice = player2choice;
    }

    public RockPaperScissorGame() {
        super("Rock Paper Scissor Game", 2);
        this.player1choice = "rock";
        this.player2choice = "rock";
    }

    public RockPaperScissorGame(String player1choice, String player2choice) {
        super("Rock Paper Scissor Game", 2);
        this.player1choice = player1choice;
        this.player2choice = player2choice;
    }

    @Override
    public void playGame() {
        System.out.println("Playing Rock Paper Scissor Game");
    }

    @Override
    public String toString() {
        return super.toString() + " {, player1Choice='" + player1choice + "', player2Choice='" + player2choice + "'}";
    }
}