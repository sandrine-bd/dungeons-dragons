package fr.campus.dungeonsdragons.board;

public class EmptyCell extends Cell {

    public EmptyCell(int position) {
        super(position);
    }

    @Override
    public String getType() {
        return "Empty";
    }

    @Override
    public String getContentName() {
        return "None";
    }

    @Override
    public String toString() {
        return "You landed on an empty cell";
    }
}
