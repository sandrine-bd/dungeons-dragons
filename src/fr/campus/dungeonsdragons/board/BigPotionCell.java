package fr.campus.dungeonsdragons.board;

public class BigPotionCell extends Cell {

    public BigPotionCell(int position) {
        super(position);
    }

    @Override
    public String getType() {
        return "Big potion";
    }

    @Override
    public String toString() {
        return "You found a big potion: Life points +5";
    }
}