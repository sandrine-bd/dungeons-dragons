package fr.campus.dungeonsdragons.board;

public abstract class Cell {
    private int position;

    public Cell(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public abstract String getType(); // Empty, Enemy, Weapon, Potion
    public abstract String getContentName(); // Nom de l'objet ou ennemi ou vide
    public abstract String toString();
}
