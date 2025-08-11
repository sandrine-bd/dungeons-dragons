package fr.campus.dungeonsdragons.board;

import java.util.Random;

public class TwentySidedDice implements Dice {
    private final Random random = new Random();

    @Override
    public int rollDice() {
        return random.nextInt(20) + 1;
    }
}
