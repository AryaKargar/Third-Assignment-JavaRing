package org.project.entity.enemies;

import org.project.entity.Entity;
import org.project.object.weapons.Weapon;

public class Goblin extends Enemy{
    public Goblin(int hp, int mp, Weapon weapon) {
        super(hp, mp, weapon);
    }

    @Override
    public void attack(Entity target) {

    }

    @Override
    public void defend() {

    }

    @Override
    public void heal(int health) {

    }

    @Override
    public void fillMana(int mana) {

    }

    @Override
    public int getMaxHP() {
        return 0;
    }

    @Override
    public int getMaxMP() {
        return 0;
    }
}
