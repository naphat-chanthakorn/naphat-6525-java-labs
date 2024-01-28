package chanthakorn.naphat.lab7;

import java.util.Comparator;

public class SortByMaxTriesGuessRange implements Comparator<GuessNumberGameVer4> {
    public int compare(GuessNumberGameVer4 game1, GuessNumberGameVer4 game2) {
        if (game1.getMaxTries() != game2.getMaxTries()) {
            return Integer.compare(game1.getMaxTries(), game2.getMaxTries());
        } else {
            return Integer.compare(game2.getMaxNum() - game2.getMinNum(), game1.getMaxNum() - game1.getMinNum());
        }
    }
}