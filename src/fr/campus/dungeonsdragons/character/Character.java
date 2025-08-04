package fr.campus.dungeonsdragons.character;

import fr.campus.dungeonsdragons.equipment.offensive.OffensiveEquipment;
import fr.campus.dungeonsdragons.equipment.defensive.DefensiveEquipment;

public abstract class Character {
    private int id;
    private String type;
    private String name;
    private int strength;
    private int lifePoints;
    private OffensiveEquipment offensiveEquipment;
    private DefensiveEquipment defensiveEquipment;

    // constructeur : initialisation des attributs
    public Character (int id, String type, String name, int strength, int lifePoints, OffensiveEquipment offensiveEquipment, DefensiveEquipment defensiveEquipment) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.strength = strength;
        this.lifePoints = lifePoints;
        this.offensiveEquipment = offensiveEquipment;
        this.defensiveEquipment = defensiveEquipment;
    }

    // autre constructeur sans id (pour création avec insertion DB)
    public Character(String type, String name, int strength, int lifePoints, OffensiveEquipment offensiveEquipment, DefensiveEquipment defensiveEquipment) {
        this(-1, type, name, strength, lifePoints, offensiveEquipment, defensiveEquipment);
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

    public int getStrength() { return strength; }
    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getLifePoints() { return lifePoints; }
    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
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
        return "Name: " + name + ", Type: " + getType() + ", Strength: " + strength + ", Life: " + lifePoints + ", Offensive equipment: " + offensiveEquipment.getName() + ", Defensive equipment: " + defensiveEquipment.getName();
    }
}
