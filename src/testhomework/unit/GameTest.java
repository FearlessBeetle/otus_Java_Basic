package testhomework.unit;


import testhomework.Assertions.Assertions;
import testhomework.game.*;
import testhomework.unit.Spy.DiceSpy;
import testhomework.unit.Spy.GameWinnerPrinterSpy;
import testhomework.unit.Stub.DiceStub;
import testhomework.unit.Stub.GameWinnerConsolePrinterStub;

import java.util.ArrayList;
import java.util.List;


public class GameTest {

    public void playGameCorrectWinnerTest() {
        String scenario = "Test for correct winnerResult A and B";
        try {
            Player playerA = new Player("A");
            Player playerB = new Player("B");
            DiceSpy diceSpy = new DiceSpy();
            GameWinnerPrinterSpy gameWinnerPrinterSpy = new GameWinnerPrinterSpy();

            Game gameTest = new Game(diceSpy, gameWinnerPrinterSpy);
            gameTest.playGame(playerA, playerB);
            String expected = "A";
            Assertions.assertEquals(expected, gameWinnerPrinterSpy.getWinnerName());
            gameTest.playGame(playerB, playerA);
            expected = "B";
            Assertions.assertEquals(expected, gameWinnerPrinterSpy.getWinnerName());
            System.out.printf("\"%s\" passed %n", scenario);

        } catch (AssertionError e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void playGameDrawResultTest() {
        String scenario = "Test for correct winnerResult for Draw";
        try {
            Player playerA = new Player("A");
            Player playerB = new Player("B");
            DiceStub diceStub = new DiceStub();
            GameWinnerConsolePrinterStub gameWinnerConsolePrinterStub =
                    new GameWinnerConsolePrinterStub();
            Game gameTest = new Game(diceStub, gameWinnerConsolePrinterStub);
            gameTest.playGame(playerA, playerB);

            String expected = "Draw result!";
            Assertions.assertEquals(expected, gameWinnerConsolePrinterStub.getWinner());
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (AssertionError e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void playGameSameWinnerTest() {
        String scenario = "Test for equal names of Players Error";
        try {
            Player playerA = new Player("A");
            Player playerB = new Player("A");
            DiceSpy diceSpy = new DiceSpy();
            GameWinnerPrinterSpy gameWinnerPrinterSpy = new GameWinnerPrinterSpy();

            Game gameTest = new Game(diceSpy, gameWinnerPrinterSpy);
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> gameTest.playGame(playerA, playerB));

            System.out.printf("\"%s\" passed %n", scenario);

        } catch (AssertionError e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void playGameCorrectMethodSubsequence() {
        String scenario = "Test for correct Subsequence of inner methods";
        try {
            List<String> expectedFlow = List.of("2", "1", "Вася");
            List<String> actualFlow = new ArrayList<>();

            Player playerA = new Player("Вася");
            Player playerB = new Player("Толя");
            DiceSpy diceSpy = new DiceSpy();
            GameWinnerPrinterSpy gameWinnerPrinterSpy = new GameWinnerPrinterSpy();
            Game gameTest = new Game(diceSpy, gameWinnerPrinterSpy);

            gameTest.playGame(playerA, playerB);

            String rollMethodActual = ("" + diceSpy.getRollCounter());
            String printWinnerActual = ("" + gameWinnerPrinterSpy.getPrintWinnerCount());
            String resultOfPrintWriter = gameWinnerPrinterSpy.getWinnerName();
            actualFlow.add(rollMethodActual);
            actualFlow.add(printWinnerActual);
            actualFlow.add(resultOfPrintWriter);

            Assertions.assertEquals(expectedFlow.size(), actualFlow.size());
            for (int i = 0; i < expectedFlow.size(); i++) {
                Assertions.assertEquals(expectedFlow.get(i), actualFlow.get(i));
            }
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (AssertionError e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}
