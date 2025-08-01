package fr.campus.dungeonsdragons.character;

import fr.campus.dungeonsdragons.equipment.offensive.OffensiveEquipment;
import fr.campus.dungeonsdragons.equipment.defensive.DefensiveEquipment;


public abstract class Character {
    private String name;
    private int lifePoints;
    private int strength;
    private OffensiveEquipment offensiveEquipment;
    private DefensiveEquipment defensiveEquipment;

    /**
     * Constructeur : initialisation des attributs
     * @param name
     * @param lifePoints
     * @param strength
     * @param offensiveEquipment
     * @param defensiveEquipment
     */
    public Character (String name, int lifePoints, int strength, OffensiveEquipment offensiveEquipment, DefensiveEquipment defensiveEquipment) {
        this.name = name;
        this.lifePoints = lifePoints;
        this.strength = strength;
        this.offensiveEquipment = offensiveEquipment;
        this.defensiveEquipment = defensiveEquipment;
    }

    public abstract String getType(); // méthode à laquelle les classes enfants devront faire appel obligatoirement

    @Override
    public String toString() {
        return "Name: " + name + ", Type: " + getType() + ", Life: " + lifePoints + ", Strength: " + strength + ", Offensive equipment: " + offensiveEquipment + ", Defensive equipment: " + defensiveEquipment;
    }

    // getters / setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getLifePoints() {
        return lifePoints;
    }
    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public int getStrength() {
        return strength;
    }
    public void setStrength(int strength) {
        this.strength = strength;
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
