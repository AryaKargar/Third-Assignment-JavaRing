package org.project.object.consumables;

import org.project.entity.Entity;

public class Flask extends Consumable {
    public Flask(int healSize, int abilityCharge) {
        super(healSize, abilityCharge);
    }

    @Override
    public void use(Entity target) {
        if(abilityCharge > 0){
            target.heal(abilitySize);
            abilityCharge -= 1;
        }
    }
}
