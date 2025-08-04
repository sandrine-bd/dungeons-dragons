package fr.campus.dungeonsdragons.board;

public class SmallPotionCell extends Cell {

    public SmallPotionCell(int position) {
        super(position);
    }

    @Override
    public String getType() {
        return "Small potion";
    }

    @Override
    public String toString() {
        return "You found a small potion: Life points +2";
    }
}