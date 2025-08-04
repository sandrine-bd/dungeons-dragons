package fr.campus.dungeonsdragons.board;

public class SorcererCell extends Cell {

    public SorcererCell(int position) {
        super(position);
    }

    @Override
    public String getType() {
        return "Sorcerer";
    }

    @Override
    public String toString() {
        return "You encountered a sorcerer!";
    }
}
