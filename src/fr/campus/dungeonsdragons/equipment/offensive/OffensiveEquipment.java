package fr.campus.dungeonsdragons.equipment.offensive;

public abstract class OffensiveEquipment {
    protected int attackBoost;
    protected String name;

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
        return getType() + " " + name + " " + attackBoost + " ATK";
    }

    public abstract class DefensiveEquipment {
        protected int defenseBoost;
        protected String name;

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
        }
}
