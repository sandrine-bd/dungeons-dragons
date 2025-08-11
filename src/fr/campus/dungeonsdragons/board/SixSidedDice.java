package fr.campus.dungeonsdragons.board;

import java.util.Random;

public class SixSidedDice implements Dice {
    private final Random random = new Random();

    @Override
    public int rollDice() {
        return random.nextInt(6) + 1;
    }
}
