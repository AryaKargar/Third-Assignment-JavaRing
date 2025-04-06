package org.project.object.weapons;

import org.project.entity.Entity;
import java.util.Random;

public class ThrowingKnives extends Weapon{
    public ThrowingKnives() {
        super(6, 0);
    }

    @Override
    public int getDamage() {
        int damageTaken = 0;
        Random random = new Random();

        for(int i = 0; i < 3; i++) {
            int randomNumber = random.nextInt(100);
            if (randomNumber >= 80) {
                damageTaken += ((int) (6 * 1.5));
                System.out.println("Critical hit! The knife strikes with deadly precision!");
            } else if (randomNumber >= 30) {
                damageTaken += (6);
                System.out.println("The knife has hit the target!");
            } else {
                System.out.println("The shot is missed!");
            }
        }
        return damageTaken;
    }
}
