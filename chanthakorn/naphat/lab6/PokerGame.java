package chanthakorn.naphat.lab6;

// PokerGame class inheriting from CardGame and implementing HasRule interface
public class PokerGame extends CardGame implements HasRule {
    // Default constructor
    public PokerGame() {
        super(); // Call superclass constructor
        this.numOfCardsPerPlayer = 5; // Set numOfCardsPerPlayer
        this.gameName = "Poker Game"; // Set gameName
        this.numOfPlayers = 4; // Set numOfPlayers
    }

    // Constructor with numOfCardsPerPlayer argument
    public PokerGame(int numOfCardsPerPlayer) {
        super(); // Call superclass constructure
        this.numOfCardsPerPlayer = numOfCardsPerPlayer; // Set numOfCardsPerPlayer
        this.gameName = "Poker Game"; // Set gameName
        this.numOfPlayers = 4; // Set numOfPlayers
    }

    // Override toString method to represent PokerGame information
    @Override
    public String toString() {
        return super.toString();
    }

    // Override playGame method implementation
    @Override
    public void playGame() {
        System.out.println("Playing Poker Game.");
    }

    // Override gameRule method implementation
    @Override
    public void gameRule() {
        System.out.println("Poker Game Rules : ...");
    }
}
