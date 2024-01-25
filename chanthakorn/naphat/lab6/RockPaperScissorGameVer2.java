package chanthakorn.naphat.lab6;

// RockPaperScissorGameVer2 class inherits from RockPaperScissorGame and implements HasRule interface
public class RockPaperScissorGameVer2 extends RockPaperScissorGame implements HasRule {
    // Default constructor
    public RockPaperScissorGameVer2() {
        super();
    }

    // Parameterized constructor
    public RockPaperScissorGameVer2(String player1choice, String player2choice) {
        super(player1choice, player2choice);
    }

    // Override toString method to include Rock Paper Scissor Game Version 2 :
    @Override
    public String toString() {
        return "Rock Paper Scissor Game Version 2 : " + super.toString();
    }

    // Override playGame method with Playing Rock Paper Scissor Game Version 2
    @Override
    public void playGame() {
        System.out.println("Playing Rock Paper Scissor Game Version 2");
    }

    // Implementation of gameRule method from HasRule interface
    @Override
    public void gameRule() {
        System.out.println("Rock Paper Scissor Rules : ...");
    }
}