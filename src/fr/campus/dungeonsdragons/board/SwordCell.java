package fr.campus.dungeonsdragons.board;

public class SwordCell extends Cell {

    public SwordCell(int position) {
        super(position);
    }

    @Override
    public String getType() {
        return "Sword";
    }

    @Override
    public String toString() {
        return "You found a sword: Strength +5";
    }
}