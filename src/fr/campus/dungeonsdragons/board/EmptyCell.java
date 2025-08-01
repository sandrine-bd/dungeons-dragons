package fr.campus.dungeonsdragons.board;

public class EmptyCell extends Cell {
    public EmptyCell(int position) {
        super(position);
    }

    @Override
    public String toString() {
        return "Cell " + getPosition() + ": empty.";
    }
}
