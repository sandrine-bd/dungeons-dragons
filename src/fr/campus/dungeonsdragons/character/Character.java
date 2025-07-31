package fr.campus.dungeonsdragons.character;

import fr.campus.dungeonsdragons.equipment.offensive.OffensiveEquipment;
import fr.campus.dungeonsdragons.equipment.defensive.DefensiveEquipment;


public abstract class Character {
    private String name;
    private int health;
    private int attack;
    private OffensiveEquipment offensiveEquipment;
    private DefensiveEquipment defensiveEquipment;

    /**
     * Constructeur : initialisation des attributs
     * @param name
     * @param health
     * @param attack
     * @param offensiveEquipment
     * @param defensiveEquipment
     */
    public Character (String name, int health, int attack, OffensiveEquipment offensiveEquipment, DefensiveEquipment defensiveEquipment) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.offensiveEquipment = offensiveEquipment;
        this.defensiveEquipment = defensiveEquipment;
    }

    public abstract String getType(); // méthode à laquelle les classes enfants devront faire appel obligatoirement

    @Override
    public String toString() {
        return "Name: " + name + ", Type: " + getType() + ", Health: " + health + ", Attack: " + attack + ", Offensive equipment: " + offensiveEquipment + ", Defensive equipment: " + defensiveEquipment;
    }

    // getters / setters
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

    public DefensiveEquipment defensiveEquipment() { return defensiveEquipment; }
    public void setDefensiveEquipment(DefensiveEquipment defensiveEquipment) {
        this.defensiveEquipment = defensiveEquipment;
    }
}
