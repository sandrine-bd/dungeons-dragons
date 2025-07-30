public class OffensiveEquipment {
    private String type; // Weapon ou Spell
    private int attackBoost;
    private String name;

    public OffensiveEquipment(String type, int attackBoost, String name) {
        this.type = type;
        this.attackBoost = attackBoost;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Offensive Equipment type : " + type + ", attack boost = " + attackBoost + ", name = " + name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAttackBoost() {
        return attackBoost;
    }

    public void setAttackBoost(int attackBoost) {
        this.attackBoost = attackBoost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
