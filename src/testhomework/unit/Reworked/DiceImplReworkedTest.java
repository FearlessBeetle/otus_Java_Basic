package testhomework.unit.Reworked;
import testhomework.game.Dice;
import testhomework.game.Reworked.DiceImplReworked;

public class DiceImplReworkedTest {
    Dice diceImplReworked = new DiceImplReworked();
    public void testDiceReworkedRandomFrom1to6() {
        String scenario = "Test for reworked random number from 1 to 6";
        try {
            int actual = diceImplReworked.roll();
            if (actual > 0 && actual <= 6) {
                System.out.printf("\"%s\" passed %n", scenario);
            } else throw new AssertionError(String.format("Expected %s = %d", "Number from 1 to 6", actual));

        } catch (AssertionError e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}
