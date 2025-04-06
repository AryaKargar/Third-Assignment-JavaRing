package org.project.object.consumables;

import org.project.object.Object;

public abstract class Consumable implements Object {
    int abilitySize;
    int abilityCharge;
    public Consumable(int abilitySize, int abilityCharge) {
        this.abilitySize = abilitySize;
        this.abilityCharge = abilityCharge;
    }
}
