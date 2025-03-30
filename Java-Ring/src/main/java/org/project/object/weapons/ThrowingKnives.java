package org.project.object.weapons;

import org.project.entity.Entity;
import java.util.Random;

public class ThrowingKnives extends Weapon{
    public ThrowingKnives() {
        super(6, 0);
    }

    @Override
    public void use(Entity target) {
        int damage = getDamage();
        Random random = new Random();

        for(int i = 0; i < 3; i++) {

            int randomNumber = random.nextInt(100);
            if (randomNumber >= 80) {
                target.takeDamage((int) (damage * 1.5));
                System.out.println("Critical hit! The knife strikes with deadly precision!");
            } else if (randomNumber >= 30) {
                target.takeDamage(damage);
                System.out.println("The knife has hit the target!");
            } else {
                System.out.println("The shot is missed!");
            }
        }

    }
}
