package fr.campus.dungeonsdragons.equipment.defensive;

public class Shield extends DefensiveEquipment {
    public Shield(int defenseBoost, String name) {
        super(defenseBoost, name);
    }

    @Override
    public String getType() {
        return "Shield";
    }
}
