package org.project.entity.players;

import org.project.entity.Entity;
import org.project.object.armors.Armor;
import org.project.object.weapons.Weapon;

public class Knight extends Player {
    public Knight(int hp, int mp, Weapon weapon, Armor armor) {
        super(hp, mp, weapon, armor);
    }


    @Override
    public String getName() {
        return "Knight";
    }

    @Override
    public void specialAbility(Entity target) {
        System.out.println("The Knight charges forward, delivering a powerful kick that knocks the enemy back with overwhelming force.");
        powerKick(target);
    }

    public void powerKick(Entity target) {
        System.out.println("The Knight delivers a powerful kick to " + target.getName() + "!");
        target.takeDamage(27);
        System.out.println(target.getName() + " takes " + 27 + " damage from the Power Kick!");
    }

}
