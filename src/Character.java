public class Character {
    private String type; // Warrior ou Wizard
    private String name;
    private int health;
    private int attack;
    private OffensiveEquipment offensiveEquipment;

    public Character (String type, String name, int health, int attack, OffensiveEquipment equipment) {
        this.type = type;
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.offensiveEquipment = equipment;
    }

    @Override // la méthode doit réécrire une méthode de la classe parente ou d'une interface
    public String toString() {
        return "Character type = " + type + ", Health = " + health + ", Attack = " + attack + ", " + offensiveEquipment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public OffensiveEquipment getOffensiveEquipment() {
        return offensiveEquipment;
    }

    public void setOffensiveEquipment(OffensiveEquipment offensiveEquipment) {
        this.offensiveEquipment = offensiveEquipment;
    }
}
