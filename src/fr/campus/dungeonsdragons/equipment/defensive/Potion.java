package fr.campus.dungeonsdragons.equipment.defensive;

public class Potion extends DefensiveEquipment {
    public Potion(int defenseBoost, String name) {
        super(defenseBoost, name);
    }

    @Override
    public String getType() {
        return "Potion";
    }
}