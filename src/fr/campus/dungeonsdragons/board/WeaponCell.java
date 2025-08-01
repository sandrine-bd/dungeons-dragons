package fr.campus.dungeonsdragons.board;

public class WeaponCell extends Cell {
    public WeaponCell(int position) {
        super(position);
    }

    @Override
    public String toString() {
        return "Cell " + getPosition() + ": you found a weapon!";
    }
}
