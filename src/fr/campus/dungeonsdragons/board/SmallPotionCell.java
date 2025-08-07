package fr.campus.dungeonsdragons.board;

import fr.campus.dungeonsdragons.character.Character;
import fr.campus.dungeonsdragons.equipment.defensive.Potion;
import fr.campus.dungeonsdragons.equipment.defensive.SmallPotion;

public class SmallPotionCell extends Cell {

    public SmallPotionCell(int position) {
        super(position);
    }

    @Override
    public String getType() {
        return "Small potion";
    }

    @Override
    public String toString() {
        return "You find a small potion: Life points +2";
    }

    @Override
    public void interact(Character character) {
        Potion potion = new SmallPotion();
        character.setLifePoints(character.getLifePoints() + potion.getDefenseBoost());
        System.out.println("You drink a small potion. Life points increased by " + potion.getDefenseBoost());
    }
}