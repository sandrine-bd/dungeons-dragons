public class DefensiveEquipment {
    private String type; // Shield ou Potion
    private int defenseBoost;
    private String name;

    public DefensiveEquipment(String type, int defenseBoost, String name) {
        this.type = type;
        this.defenseBoost = defenseBoost;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Defensive Equipment type : " + type + ", defense boost = " + defenseBoost + ", name = " + name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDefenseBoost() {
        return defenseBoost;
    }

    public void setDefenseBoost(int defenseBoost) {
        this.defenseBoost = defenseBoost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
