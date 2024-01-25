package chanthakorn.naphat.lab6;

// DungeonsAndDragonsGame class inheriting from CardGame and implementing multiple interfaces
public class DungeonsAndDragonsGame extends CardGame implements HasRule, UseBoard, UseDice {
    public DungeonsAndDragonsGame() {
        // Default constructor
        super(); // Call superclass constructor
        this.gameName = "Dungeons And Dragons Game"; // Set gameName
        this.numOfPlayers = 3; // Set numOfPlayers
    }

    // Constructor with numOfCardsPerPlayer argument
    public DungeonsAndDragonsGame(int numOfCardsPerPlayer) {
        super(); // Call superclass constructor
        this.numOfCardsPerPlayer = numOfCardsPerPlayer; // Set numOfCardsPerPlayer
        this.gameName = "Dungeons And Dragons Game"; // Set gameName
        this.numOfPlayers = 3; // Set numOfPlayers
    }

    // Override toString method to represent DungeonsAndDragonsGame information
    @Override
    public String toString() {
        return "Dungeons And Dragons Game : " + super.toString();
    }

    // Override playGame method implementation
    @Override
    public void playGame() {
        System.out.println("Playing Dungeons And Dragons Game");
    }

    // Override gameRule method implementation
    @Override
    public void gameRule() {
        System.out.println("Dungeons And Dragons Game Rules : ...");
    }

    // Override setUpBoard method implementation
    @Override
    public void setUpBoard() {
        System.out.println("Setting up board for Dungeons And Dragons Game");
    }

    // Override gameRule method implementation
    @Override
    public void rollDice() {
        System.out.println("Rolling 2 dices for Dungeons And Dragons Game");
    }
}