package org.project.entity.players;

import org.project.object.armors.Armor;
import org.project.object.weapons.Weapon;

public class Wizard extends Player{
    public Wizard(String name, int hp, int mp, Weapon weapon, Armor armor) {
        super(name, hp, mp, weapon, armor);
    }
}
