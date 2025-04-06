package org.project.object.consumables;

import org.project.entity.Entity;
import org.project.entity.players.Wizard;

public class Posion extends Consumable {

    public Posion(int healSize, int abilityCharge) {
        super(healSize, abilityCharge);
    }


    @Override
    public void use(Entity target) {
        if(abilityCharge > 0){
            target.addMana(abilitySize);
            abilityCharge -= 1;
        }
    }

}
