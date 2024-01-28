package chanthakorn.naphat.lab7;

import chanthakorn.naphat.lab5.GuessNumberGameVer3;

public class GuessNumberGameVer4 extends chanthakorn.naphat.lab5.GuessNumberGameVer3 {
    public GuessNumberGameVer4() {
        super();
    }

    public GuessNumberGameVer4(int minNum, int maxNum) {
        super(minNum, maxNum);
    }

    public GuessNumberGameVer4(int minNum, int maxNum, int maxTries) {
        super(minNum, maxNum, maxTries);
    }

    @Override
    public String toString() {
        return "GuessNumberGameVer4 (min:" + getMinNum() + ", max:" + getMaxNum() +
                ", max Tries:" + getMaxTries() + ")";
    }
}