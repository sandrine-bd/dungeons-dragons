package fr.campus.dungeonsdragons.board;

public class PotionCell extends Cell {
    public PotionCell(int position) {
        super(position);
    }

    @Override
    public String toString() {
        return "Cell " + getPosition() + ": you found a potion!";
    }
}
