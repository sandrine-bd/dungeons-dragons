package fr.campus.dungeonsdragons.board;

import fr.campus.dungeonsdragons.character.Character;

public class EnemyCell extends Cell {
    private Character enemy;

    public EnemyCell(int position, Character enemy) {
        super(position);
        this.enemy = enemy;
    }

    @Override
    public String getType() {
        return "Enemy";
    }

    @Override
    public String getContentName() {
        return enemy.getName();
    }

    @Override
    public String toString() {
        return "You encountered an enemy: " + enemy.toString();
    }

    public Character getEnemy() {
        return enemy;
    }
}
