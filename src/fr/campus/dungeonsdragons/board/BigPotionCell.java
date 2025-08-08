package fr.campus.dungeonsdragons.board;

import fr.campus.dungeonsdragons.character.Character;
import fr.campus.dungeonsdragons.equipment.defensive.Potion;
import fr.campus.dungeonsdragons.equipment.defensive.BigPotion;

public class BigPotionCell extends Cell {

    public BigPotionCell(int position) {
        super(position);
    }

    @Override
    public String getType() {
        return "Big potion";
    }

    @Override
    public String toString() {
        return "You find a big potion!";
    }

    @Override
    public void interact(Character character) {
        Potion potion = new BigPotion();
        character.setLifePoints(character.getLifePoints() + potion.getDefenseBoost());
        System.out.println("Life points +" + potion.getDefenseBoost());
    }
}