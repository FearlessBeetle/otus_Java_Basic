package testhomework.unit.Spy;

import testhomework.game.Dice;


public class DiceSpy implements Dice {
    private boolean isFistPlayer = true;
    private int rollCounter = 0;

    @Override
    public int roll() {
        if (isFistPlayer) {
            isFistPlayer = false;
            rollCounter++;
            return 6;
        } else {
            rollCounter++;
            isFistPlayer = true;
            return 5;
        }
    }

    public int getRollCounter() {
        return rollCounter;
    }
}
