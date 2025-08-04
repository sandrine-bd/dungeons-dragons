package fr.campus.dungeonsdragons.board;

public class FireballCell extends Cell {

    public FireballCell(int position) {
        super(position);
    }

    @Override
    public String getType() {
        return "Fireball";
    }

    @Override
    public String toString() {
        return "You found a fireball: Strength +7";
    }
}