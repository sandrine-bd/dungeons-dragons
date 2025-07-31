package fr.campus.dungeonsdragons.equipment.defensive;

public abstract class DefensiveEquipment {
    protected int defenseBoost;
    protected String name;

    /**
     *
     * @param defenseBoost
     * @param name
     */
    public DefensiveEquipment(int defenseBoost, String name) {
        this.defenseBoost = defenseBoost;
        this.name = name;
    }

    public int getDefenseBoost() {
        return defenseBoost;
    }

    public String getName() {
        return name;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return name + " = " + defenseBoost + " health points";
    }
}
