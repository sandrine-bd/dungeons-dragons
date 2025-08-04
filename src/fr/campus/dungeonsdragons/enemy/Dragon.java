package fr.campus.dungeonsdragons.enemy;

public class Dragon extends Enemy {
    public Dragon(String type, int strength, int lifePoints) {
        super(type, strength, lifePoints);
    }

    public String getType() {
        return "Dragon";
    }
}
