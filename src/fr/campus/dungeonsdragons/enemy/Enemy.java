package fr.campus.dungeonsdragons.enemy;

public abstract class Enemy {
    private String type;
    private int strength;
    private int lifePoints;

    public Enemy (String type, int strength, int lifePoints) {
        this.type = type;
        this.strength = strength;
        this.lifePoints = lifePoints;
    }

    public String getType () { return type; }
    public void setType (String type) { this.type = type; }

    public String getName() { return type; }
    public void setName (String name){ this.type = name; }

    public int getStrength() { return strength; }
    public void setStrength(int strength) { this.strength = strength; }

    public int getLifePoints() { return lifePoints; }
    public void setLifePoints(int lifePoints) { this.lifePoints = lifePoints; }

    @Override
    public String toString() {
        return "Type: " + type + "Strength: " + strength + ", Life: " + lifePoints;
    }
}