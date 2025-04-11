package org.project.entity.enemies;

import org.project.entity.Entity;
import org.project.entity.players.Player;
import org.project.object.weapons.Weapon;

import java.util.Random;

public class Dragon extends Enemy {
    public Dragon(int hp, int mp, Weapon weapon) {
        super(hp, mp, weapon);
    }

    @Override
    public void heal(int health) {
        System.out.println("Dragon cannot heal itself!");
    }

    @Override
    public String getName(){
        return "Dragon";
    }

    @Override
    public void specialAbility(Entity target) {
        System.out.println("Dragon's special ability is fire breath. it deals damage!");
    }

    public void fireBreath(Player target) {
        System.out.println("The Dragon unleashes a fiery breath!");

        Random random = new Random();
        int damage = random.nextInt(30, 51); // Deals between 30 and 50 damage
        target.takeDamage(damage);
        System.out.println(target.getName() + " takes " + damage + " fire damage!");
    }
}
