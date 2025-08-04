package fr.campus.dungeonsdragons.board;

public class ClubCell extends Cell {

    public ClubCell(int position) {
        super(position);
    }

    @Override
    public String getType() {
        return "Club";
    }

    @Override
    public String toString() {
        return "You found a club: Strength +3";
    }
}
