package fr.campus.dungeonsdragons.equipment.offensive;

public class Spell extends OffensiveEquipment {
    public Spell(int attackBoost, String name) {
        super(attackBoost, name);
    }

    @Override
    public String getType() {
        return "Spell";
    }
}
