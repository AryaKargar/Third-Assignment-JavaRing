package org.project.entity.enemies;

import org.project.entity.Entity;
import org.project.object.weapons.Weapon;

import java.util.Random;

public class Skeleton extends Enemy {
    private boolean revived = false;
    public Skeleton(int hp, int mp, Weapon weapon) {
        super(hp, mp, weapon);
    }

    @Override
    public void heal(int health) {
        Random random = new Random();
        int extraHeal = random.nextInt(5, 16);
        this.currentHP = Math.min(this.currentHP + health + extraHeal, maxHP);
        System.out.println(getClass().getSimpleName() + " healed for " + health + " HP. Current HP: " + currentHP);

    }

    @Override
    public String getName() {
        return "Skeleton";
    }

    @Override
    public void specialAbility() {
        System.out.println("The Skeleton has no special ability... but it refuses to stay dead!");


    }
    public void revive() {
        if (!revived && this.getCurrentHP() <= 0) {
            revived = true;
            int reviveHp = this.getMaxHP() / 2;
            this.heal(reviveHp);
            System.out.println("💀 The Skeleton reassembles itself and revives with " + reviveHp + " HP!");
        }
    }
}
