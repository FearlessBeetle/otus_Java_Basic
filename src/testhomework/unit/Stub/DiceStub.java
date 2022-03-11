package testhomework.unit.Stub;

import testhomework.game.Dice;

public class DiceStub implements Dice {
    @Override
    public int roll() {
        return 5;
    }
}
