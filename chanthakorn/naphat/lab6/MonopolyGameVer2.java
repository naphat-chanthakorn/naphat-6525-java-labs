package chanthakorn.naphat.lab6;

// MonopolyGameVer2 class inherits from MonopolyGame and implements HasRule, UseBoard, and UseDice interfaces
public class MonopolyGameVer2 extends MonopolyGame implements HasRule, UseBoard, UseDice {
    // Default constructor
    public MonopolyGameVer2() {
        super();
    }

    // Parameterized constructor
    public MonopolyGameVer2(String[] gamePieces) {
        super(gamePieces);
    }

    // Override toString method to include Monopoly Game Version 2 :
    @Override
    public String toString() {
        return "Monopoly Game Version 2 : " + super.toString();
    }

    // Override playGame method with Play Monopoly Game Version 2
    @Override
    public void playGame() {
        System.out.println("Play Monopoly Game Version 2");
    }

    // Implementation of setUpBoard method from UseBoard interface
    @Override
    public void setUpBoard() {
        System.out.println("Set up monopoly board");
    }

    // Implementation of gameRule method from HasRule interface
    @Override
    public void gameRule() {
        System.out.println("Monopoly Game Rules : ...");
    }

    // Implementation of rollDice method from UseDice interface
    @Override
    public void rollDice() {
        System.out.println("Roll 2 dice for monopoly game");
    }
}