package org.project.entity.players;

import org.project.entity.Entity;
import org.project.object.armors.Armor;
import org.project.object.weapons.Weapon;

public class Knight extends Player {
    int turnCounter = 0;

    public Knight(int hp, int mp, Weapon weapon, Armor armor) {
        super(hp, mp, weapon, armor);
    }


    @Override
    public String getName() {
        return "Knight";
    }

    @Override
    public void specialAbility() {
        System.out.println("The Knight charges forward, delivering a powerful kick that knocks the enemy back with overwhelming force.");
    }

    public void powerKick(Entity target) {
        if (turnCounter >= 3) {
            turnCounter = 0;
        } else {
            System.out.println("The Knight is waiting for the right moment to use Power Kick.");
            return;
        }
        System.out.println("The Knight delivers a powerful kick to " + target.getName() + "!");
        int damage = 30;
        target.takeDamage(damage);
        System.out.println(target.getName() + " takes " + damage + " damage from the Power Kick!");
    }

    public void endTurn() {
        turnCounter++;
    }
}
