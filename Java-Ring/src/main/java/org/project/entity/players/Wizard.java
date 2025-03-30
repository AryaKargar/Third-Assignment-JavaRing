package org.project.entity.players;

import org.project.entity.Entity;
import org.project.object.armors.Armor;
import org.project.object.weapons.Weapon;

import java.util.Random;

public class Wizard extends Player {

    public Wizard(int hp, int mp, Weapon weapon, Armor armor) {
        super(hp, mp, weapon, armor);
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
        super.takeDamage(damage);
        currentMP = Math.min(currentMP + damage / 4, maxMP);
    }

    @Override
    public String getName() {
        return "Wizard";
    }

    @Override
    public void specialAbility() {
        System.out.println("The Wizard raises their staff, casting a powerful spell that strikes the enemy while healing their own wounds.");
    }

    public void healDamageSpell(Entity target) {
        if (currentMP >= 15) {
            currentMP -= 15;
        } else {
            System.out.println("Not enough mana to cast Heal-Damage spell.");
            return;
        }
        Random random = new Random();
        int damage = random.nextInt(15, 31); // Deals between 15 and 30 damage

        target.takeDamage(damage);
        System.out.println(target.getName() + " takes " + damage + " damage!");

        int healing = damage / 3;
        this.heal(healing);
        System.out.println(getName() + " heals for " + healing + " health!");
    }

    public int getMana() {
        return currentMP;
    }
}
