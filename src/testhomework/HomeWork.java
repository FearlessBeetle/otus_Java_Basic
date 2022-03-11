package testhomework;


import testhomework.unit.DiceImplTest;
import testhomework.unit.GameTest;
import testhomework.unit.Reworked.DiceImplReworkedTest;
import testhomework.unit.Reworked.GameReworkedTest;

public class HomeWork {

    /*
        Заготовка для ДЗ представляет собой игру в кости.
        При вызове game.playGame(), два игрока кидают кости.
        Выигрывает игрок, у кого результат (1-6) больше

        Написать тесты (минимум 4) на классы DiceImpl и Game.
        Тесты должны найти не менее двух ошибок.

        Информацию о пройденном тесте предлагается выводить в System.out, а об упавшем в System.err
     */
    public static void main(String[] args) {
        DiceImplTest diceImplTest = new DiceImplTest();
        diceImplTest.testDiceRandomFrom1to6();
        diceImplTest.testDiceRandomFromNTo1AndFrom6ToN();

        GameTest gameTest = new GameTest();
        gameTest.playGameCorrectWinnerTest();
        gameTest.playGameDrawResultTest();
        gameTest.playGameSameWinnerTest();
        gameTest.playGameCorrectMethodSubsequence();

//        DiceImplReworkedTest diceImplReworkedTest = new DiceImplReworkedTest();
//        diceImplReworkedTest.testDiceReworkedRandomFrom1to6();
//
//        GameReworkedTest gameReworkedTest = new GameReworkedTest();
//        gameReworkedTest.playGameReworkedCorrectWinnerTest();
//        gameReworkedTest.playGameReworkedDrawResultTest();
//        gameReworkedTest.playGameReworkedSameWinnerTest();
//        gameReworkedTest.playGameReworkedCorrectMethodSubsequence();

    }
    
}