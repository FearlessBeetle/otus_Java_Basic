package testhomework.unit;

import banksystem.WrongInputException;
import testhomework.Assertions.Assertions;
import testhomework.game.Dice;
import testhomework.game.DiceImpl;

public class DiceImplTest {
    private final Dice diceImpl = new DiceImpl();

    public void testDiceRandomFrom1to6() {
        String scenario = "Test for random number from 1 to 6";
        try {
                int actual = diceImpl.roll();
                if (actual >= 1 && actual <= 6) {
                    System.out.printf("\"%s\" passed %n", scenario);
                } else throw new AssertionError(String.format(
                        "Expected %s = %d", "Number from 1 to 6",
                        actual));
        } catch (AssertionError e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    // По логике вещей если бы число не попадало в диапазон
    // мы бы хотели видеть исключение, но из-за способа реализации с помощью Random
    // если починить диапазон nextInt(1,7) то никакое исключение уже не может возникнуть
    // и проверять было бы нечего, поэтому в Reworked классе я этот тест вставлять не стал.
    public void testDiceRandomFromNTo1AndFrom6ToN() {
        String scenario = "Test for random number out of range 1 - 6";
        try {
            int actual = diceImpl.roll();
            if (actual <= 0 || actual >= 7) {
                Assertions.assertThrows(IllegalArgumentException.class, diceImpl::roll);
            } else { System.out.printf("\"%s\" passed %n", scenario);}

        } catch (AssertionError e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}
