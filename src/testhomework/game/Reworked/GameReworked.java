package testhomework.game.Reworked;

import testhomework.game.Dice;
import testhomework.game.GameWinnerPrinter;
import testhomework.game.Player;

public class GameReworked {

    private final Dice dice;
    private final GameWinnerPrinter winnerPrinter;

    public GameReworked(Dice dice, GameWinnerPrinter winnerPrinter) {
        this.dice = dice;
        this.winnerPrinter = winnerPrinter;
    }

    public void playGame(Player player1, Player player2) {
        int player1Result = dice.roll();
        int player2Result = dice.roll();
        if (player1Result == player2Result) {
            winnerPrinter.printWinner(new Player("Draw result!"));
        } else if (player1.getName().equals(player2.getName())) {
            throw new IllegalArgumentException("Names of players are equals, " +
                    "cant resolve winner!");
        } else {
            Player winner = (player1Result > player2Result) ? player1 : player2;
            winnerPrinter.printWinner(winner);
        }
    }

}
