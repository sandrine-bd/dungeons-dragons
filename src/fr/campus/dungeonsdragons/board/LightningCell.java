package fr.campus.dungeonsdragons.board;

public class LightningCell extends Cell {

    public LightningCell(int position) {
        super(position);
    }

    @Override
    public String getType() {
        return "Lightning";
    }

    @Override
    public String toString() {
        return "You found a lightning: Strength +2";
    }
}