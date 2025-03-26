package org.project.entity.enemies;

import org.project.object.weapons.Weapon;
import org.project.entity.Entity;

public abstract class Enemy implements Entity {
    protected Weapon weapon;
    protected int maxHP, currentHP;
    protected int maxMP, currentMP;

    public Enemy(int maxHP, int maxMP, Weapon weapon) {
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.maxMP = maxMP;
        this.currentMP = maxMP;
        this.weapon = weapon;
    }

    @Override
    public void attack(Entity target) {
        int damage = weapon.getDamage();
        System.out.println(getClass().getSimpleName() + " attacks " + target.getClass().getSimpleName() +
                " with " + weapon.getClass().getSimpleName() + " for " + damage + " damage!");
        target.takeDamage(damage);
    }

    @Override
    public void takeDamage(int damage) {
        currentHP = Math.max(currentHP - damage, 0);
        System.out.println(getClass().getSimpleName() + " took " + damage + " damage. Current HP: " + currentHP);
    }

    @Override
    public boolean isAlive() {
        return currentHP > 0;
    }

    @Override
    public int getMaxHP() {
        return maxHP;
    }

    @Override
    public int getCurrentHP() {
        return currentHP;
    }

    @Override
    public int getMaxMP() {
        return maxMP;
    }

    @Override
    public int getCurrentMP() {
        return currentMP;
    }

    @Override
    public void heal(int health) {
        this.currentHP = Math.min(this.currentHP + health, maxHP);
        System.out.println(getClass().getSimpleName() + " healed for " + health + " HP. Current HP: " + currentHP);
    }

    @Override
    public void fillMana(int mana) {
        this.currentMP = Math.min(this.currentMP + mana, maxMP);
        System.out.println(getClass().getSimpleName() + " restored " + mana + " MP. Current MP: " + currentMP);
    }

    public Weapon getWeapon() {
        return weapon;
    }
}