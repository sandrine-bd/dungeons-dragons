package fr.campus.dungeonsdragons.board;

public class DragonCell extends Cell {

    public DragonCell(int position) {
        super(position);
    }

    @Override
    public String getType() {
        return "Dragon";
    }

    @Override
    public String toString() {
        return "You encountered a dragon!";
    }
}
