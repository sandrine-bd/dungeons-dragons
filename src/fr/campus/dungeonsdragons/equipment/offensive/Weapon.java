package fr.campus.dungeonsdragons.equipment.offensive;

public abstract class Weapon extends OffensiveEquipment {
    public Weapon(int attackBoost, String name) {
        super(attackBoost, name);
    }

    @Override
    public String getType() {
        return "Weapon";
    }
}
