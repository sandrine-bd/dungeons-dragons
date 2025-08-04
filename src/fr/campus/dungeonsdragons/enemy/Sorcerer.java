package fr.campus.dungeonsdragons.enemy;

public class Sorcerer extends Enemy {
    public Sorcerer (String type, int strength, int lifePoints) {
        super(type, strength, lifePoints);
    }

    public String getType() {
        return "Sorcerer";
    }
}
