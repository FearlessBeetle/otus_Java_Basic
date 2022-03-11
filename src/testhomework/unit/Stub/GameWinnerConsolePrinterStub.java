package testhomework.unit.Stub;

import testhomework.game.GameWinnerPrinter;
import testhomework.game.Player;

public class GameWinnerConsolePrinterStub implements GameWinnerPrinter {
    String winner;
    @Override
    public void printWinner(Player winner) {
        this.winner = winner.getName();
    }

    public String getWinner() {
        return winner;
    }
}
