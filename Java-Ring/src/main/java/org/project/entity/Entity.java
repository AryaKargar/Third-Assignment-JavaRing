package org.project.entity;

public interface Entity {
    void attack(Entity target);

    void defend();

    void heal(int health);

    void fillMana(int mana);

    void takeDamage(int damage);

    int getMaxHP();

    int getMaxMP();

    int getCurrentHP();

    int getCurrentMP();

    boolean isAlive();

    String getName();
}
