package fr.campus.dungeonsdragons.character;

import fr.campus.dungeonsdragons.equipment.offensive.OffensiveEquipment;
import fr.campus.dungeonsdragons.equipment.defensive.DefensiveEquipment;

public abstract class Character {
    private int id;
    private String type;
    private String name;
    private int lifePoints;
    private int strength;
    private OffensiveEquipment offensiveEquipment;
    private DefensiveEquipment defensiveEquipment;

    // constructeur : initialisation des attributs
    public Character (int id, String type, String name, int lifePoints, int strength, OffensiveEquipment offensiveEquipment, DefensiveEquipment defensiveEquipment) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.lifePoints = lifePoints;
        this.strength = strength;
        this.offensiveEquipment = offensiveEquipment;
        this.defensiveEquipment = defensiveEquipment;
    }

    // autre constructeur sans id (pour création avec insertion DB)
    public Character(String type, String name, int lifePoints, int strength, OffensiveEquipment offensiveEquipment, DefensiveEquipment defensiveEquipment) {
        this(-1, type, name, lifePoints, strength, offensiveEquipment, defensiveEquipment);
    }

    // getters / setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getLifePoints() { return lifePoints; }
    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public int getStrength() { return strength; }
    public void setStrength(int strength) {
        this.strength = strength;
    }

    public OffensiveEquipment getOffensiveEquipment() {
        return offensiveEquipment;
    }
    public void setOffensiveEquipment(OffensiveEquipment offensiveEquipment) {
        this.offensiveEquipment = offensiveEquipment;
    }

    public DefensiveEquipment getDefensiveEquipment() { return defensiveEquipment; }
    public void setDefensiveEquipment(DefensiveEquipment defensiveEquipment) {
        this.defensiveEquipment = defensiveEquipment;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Type: " + getType() + ", Life: " + lifePoints + ", Strength: " + strength + ", Offensive equipment: " + offensiveEquipment.getName() + ", Defensive equipment: " + defensiveEquipment.getName();
    }
}
