package fr.campus.dungeonsdragons.board;

import fr.campus.dungeonsdragons.character.Character;

public abstract class Cell {
    private int position;

    public Cell(int position) { this.position = position; }

    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
    }

    public abstract void interact(Character character);

    public abstract String getType();

    @Override
    public abstract String toString();
}
