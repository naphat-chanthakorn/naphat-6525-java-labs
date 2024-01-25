package chanthakorn.naphat.lab6;

// GuessNumberGameVer2 class inherits from GuessNumberGameVer1 and implements HasRule interface
public class GuessNumberGameVer2 extends GuessNumberGameVer1 implements HasRule {
    // Default constructor
    public GuessNumberGameVer2() {
        super();
    }

    // Parameterized constructor
    public GuessNumberGameVer2(int minNum, int maxNum, int maxTries) {
        super(minNum, maxNum, maxTries);
    }

    // Override toString method to include Guess Number Game Version 2 :
    @Override
    public String toString() {
        return "Guess Number Game Version 2 : " + super.toString();
    }

    // Override playGame method with Playing Guess Number Game Verion 2
    @Override
    public void playGame() {
        System.out.println("Playing Guess Number Game Verion 2");
    }

    // Implementation of gameRule method from HasRule interface
    @Override
    public void gameRule() {
        System.out.println("Guess Number Game Rules : ...");
    }
}