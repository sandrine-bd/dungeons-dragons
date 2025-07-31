package fr.campus.dungeonsdragons.equipment.offensive;

public abstract class OffensiveEquipment {
    protected int attackBoost;
    protected String name;

    /**
     *
     * @param attackBoost
     * @param name
     */
    public OffensiveEquipment(int attackBoost, String name) {
        this.attackBoost = attackBoost;
        this.name = name;
    }

    public int getAttackBoost() {
        return attackBoost;
    }

    public String getName() {
        return name;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return name + " = " + attackBoost + " attack points";
    }
}
