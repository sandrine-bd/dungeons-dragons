package fr.campus.dungeonsdragons.board;

public class EnemyCell extends Cell {
    public EnemyCell(int position) {
        super(position);
    }

    @Override
    public String toString() {
        return "Cell " + getPosition() + ": an enemy blocks the way!";
    }
}
