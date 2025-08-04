package fr.campus.dungeonsdragons.board;

import fr.campus.dungeonsdragons.equipment.offensive.Weapon;

public class WeaponCell extends Cell {
    private Weapon weapon;

    public WeaponCell(int position, Weapon weapon) {
        super(position);
        this.weapon = weapon;
    }

    @Override
    public String getType() {
        return "Weapon";
    }

    @Override
    public String getContentName() {
        return weapon.getName();
    }

    @Override
    public String toString() {

        return "You found a weapon: " + weapon.getName() + " (Attack +" + weapon.getAttackBoost() + ")";
    }

    public Weapon getWeapon() {
        return weapon;
    }
}
