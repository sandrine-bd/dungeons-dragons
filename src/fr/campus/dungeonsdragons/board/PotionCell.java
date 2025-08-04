package fr.campus.dungeonsdragons.board;

import fr.campus.dungeonsdragons.equipment.defensive.Potion;

public class PotionCell extends Cell {
    private Potion potion;

    public PotionCell(int position, Potion potion) {
        super(position);
        this.potion = potion;
    }

    @Override
    public String getType() {
        return "Potion";
    }

    @Override
    public String getContentName() {
        return potion.getName();
    }

    @Override
    public String toString() {
        return "You found a potion: " + potion.getName() + " (Heals+" + potion.getDefenseBoost() + ")";
    }

    public Potion getPotion() {
        return potion;
    }
}
