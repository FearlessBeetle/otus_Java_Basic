package testhomework.unit.Spy;

import testhomework.game.GameWinnerPrinter;
import testhomework.game.Player;

public class GameWinnerPrinterSpy implements GameWinnerPrinter {
    private int printWinnerCount = 0;
    String winnerName;

    @Override
    public void printWinner(Player winner) {
        this.winnerName = winner.getName();
        printWinnerCount++;
    }

    public String getWinnerName() {
        return winnerName;
    }

    public int getPrintWinnerCount() {
        return printWinnerCount;
    }
}
