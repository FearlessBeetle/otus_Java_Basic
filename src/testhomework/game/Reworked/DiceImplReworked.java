package testhomework.game.Reworked;

import testhomework.game.Dice;

import java.util.Random;

public class DiceImplReworked implements Dice {
    @Override
    public int roll() {
        // https://docs.oracle.com/javase/8/docs/api/java/util/Random.html
        return new Random().nextInt(1,7);
    }
}
