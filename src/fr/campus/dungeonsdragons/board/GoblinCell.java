package fr.campus.dungeonsdragons.board;

public class GoblinCell extends Cell {

    public GoblinCell(int position) {
        super(position);
    }

    @Override
    public String getType() {
        return "Goblin";
    }

    @Override
    public String toString() {
        return "You encountered a goblin!";
    }
}
