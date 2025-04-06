package org.project.entity.enemies;

import org.project.entity.Entity;
import org.project.entity.players.Player;
import org.project.object.weapons.Weapon;

public class Goblin extends Enemy{
    public Goblin(int hp, int mp, Weapon weapon) {
        super(hp, mp, weapon);
    }


    @Override
    public String getName() {
        return "Goblin";
    }

    @Override
    public void specialAbility(Entity target) {
        System.out.println("Goblin special ability is stealing enemy's health");
    }

    public void Steal(Player target) {

        int stolenHp = 10;

        if (target.getCurrentHP() > stolenHp) {
            target.takeDamage(stolenHp);
            this.heal(stolenHp);
            System.out.println("The Goblin steals " + stolenHp + " HP from " + target.getName() + "!");
        }
    }
}
