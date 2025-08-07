package fr.campus.dungeonsdragons.board;

import fr.campus.dungeonsdragons.character.Character;

public class EmptyCell extends Cell {

    public EmptyCell(int position) {
        super(position);
    }

    @Override
    public String getType() {
        return "Empty";
    }

    @Override
    public String toString() {
        return "You land on an empty cell";
    }

    @Override
    public void interact (Character character) {
        System.out.println("Empty cell");
    }
}
