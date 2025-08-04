package fr.campus.dungeonsdragons.enemy;

public class Goblin  extends Enemy {
    public Goblin(String type, int strength, int lifePoints) {
        super(type, strength, lifePoints);
    }

    public String getType() {
        return "Goblin";
    }
}