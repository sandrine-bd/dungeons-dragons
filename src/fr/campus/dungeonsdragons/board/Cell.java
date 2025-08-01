package fr.campus.dungeonsdragons.board;

public abstract class Cell {
    private final int position;

    public Cell(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public abstract String toString();
}
