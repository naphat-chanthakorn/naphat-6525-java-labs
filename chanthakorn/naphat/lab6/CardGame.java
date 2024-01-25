package chanthakorn.naphat.lab6;

// Abstract class CardGame inherited from Game
abstract class CardGame extends Game {
    // Number of cards per player
    protected int numOfCardsPerPlayer;

    // Getter for numOfCardsPerPlayer
    public int getNumOfCardsPerPlayer() {
        return numOfCardsPerPlayer;
    }

    // Setter for numOfCardsPerPlayer
    public void setNumOfCardsPerPlayer(int numOfCardsPerPlayer) {
        this.numOfCardsPerPlayer = numOfCardsPerPlayer;
    }

    // Default constructor initializes numOfCardsPerPlayer to 0
    public CardGame() {
        super(); // Call superclass constructor
        numOfCardsPerPlayer = 0; // Initialize numOfCardsPerPlayer
    }

    // Constructor with argument to set numOfCardsPerPlayer
    public CardGame(int numOfCardsPerPlayer) {
        super(); // Call superclass constructor
        this.numOfCardsPerPlayer = numOfCardsPerPlayer; // Set numOfCardsPerPlayer
    }

    // Override toString method to display information about the CardGame
    @Override
    public String toString() {
        return super.toString() + " {numOfCardsPerPlayer='" + numOfCardsPerPlayer + "'}";
    }

    // Abstract method playGame to be implemented by subclasses
    abstract void playGame();
}