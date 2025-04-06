package org.project.entity.players;

import org.project.entity.Entity;
import org.project.object.armors.Armor;
import org.project.object.weapons.Weapon;

import java.util.Random;

public class Assassin extends Player {
    public Assassin(int hp, int mp, Weapon weapon, Armor armor) {
        super(hp, mp, weapon, armor);
    }

    @Override
    public String getName() {
        return "Assassin";
    }

    @Override
    public void specialAbility(Entity target) {
        System.out.println("The Assassin vanishes into the shadows... and strikes!");
        inToShadows(target);
    }


    public void inToShadows(Entity target) {
        Random random = new Random();
        boolean criticalHit = random.nextInt(100) < 30;
        int damage = criticalHit ? 25 : 13;

        target.takeDamage(damage);

        if (criticalHit) {
            System.out.println("Critical Hit! " + target.getName() + " takes " + damage + " damage!");
        } else {
            System.out.println(target.getName() + " takes " + damage + " damage.");
        }
    }


    @Override
    public void takeDamage(int damage) {
        Random random = new Random();
        boolean evaded = random.nextInt(100) < 15;

        if (evaded) {
            System.out.println("The Assassin swiftly dodges the attack!");
        } else {
            super.takeDamage(damage);
        }
    }
}
