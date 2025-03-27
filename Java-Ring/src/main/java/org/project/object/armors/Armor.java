package org.project.object.armors;

import org.project.object.Object;

public abstract class Armor implements Object {
    private int defense;
    private int maxDefense;
    private int durability;
    private int maxDurability;

    private boolean isBroke;

    public Armor(int defense, int durability) {
        this.maxDefense = defense; // Set max defense value
        this.maxDurability = durability; // Set max durability value
        this.defense = defense;
        this.durability = durability;
        this.isBroke = false;
    }

    public boolean checkBreak() {
        if (durability <= 0) {
            isBroke = true;
            defense = 0;
            return true;
        }
        return false;
    }

    public void use(){
        this.durability -= 1;
    }
    public void repair() {
        isBroke = false;
        defense = maxDefense;
        durability = maxDurability;
    }

    public int getDefense() {
        return defense;
    }

    public int getDurability() {
        return durability;
    }

    public boolean isBroke() {
        return isBroke;
    }
}
