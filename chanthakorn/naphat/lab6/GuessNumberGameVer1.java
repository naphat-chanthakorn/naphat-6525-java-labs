package chanthakorn.naphat.lab6;

public class GuessNumberGameVer1 extends Game {
    protected int minNum, maxNum, correctNum, maxTries;

    public int getMinNum() {
        return minNum;
    }

    public void setMinNum(int minNum) {
        this.minNum = minNum;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    public int getMaxTries() {
        return maxTries;
    }

    public void setMaxTries(int maxTries) {
        this.maxTries = maxTries;
    }

    public String getGameName() {
        return gameName;
    }

    public GuessNumberGameVer1() {
        super("Guess Number Game", 1);
        this.minNum = 1;
        this.maxNum = 10;
        this.correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
        this.maxTries = 3;
    }

    public GuessNumberGameVer1(int minNum, int maxNum) {
        super("Guess Number Game", 1);
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
    }

    public GuessNumberGameVer1(int minNum, int maxNum, int maxTries) {
        super("Guess Number Game", 1);
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
        this.maxTries = maxTries;
    }

    @Override
    public String toString() {
        return super.toString() + " { minNum='" + minNum + "', maxNum='" + maxNum + "', correctNum='" + correctNum
                + "', maxTries='" + maxTries + "'}";
    }

    @Override
    public void playGame() {
        System.out.println("Playing Guess Number Guess");
    }
}