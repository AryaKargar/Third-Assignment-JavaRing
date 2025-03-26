package org.project.location;

import org.project.entity.enemies.Enemy;
import java.util.ArrayList;

public class Location {
    private String name;
    private ArrayList<Enemy> enemies;

    public Location(String name, ArrayList<Enemy> enemies) {
        this.name = name;
        this.enemies = enemies;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    public void removeEnemy(Enemy enemy) {
        enemies.remove(enemy);
    }

    public void resetLocation(ArrayList<Enemy> newEnemies) {
        this.enemies = (newEnemies != null) ? newEnemies : new ArrayList<>();
        System.out.println(name + " has been reset with new enemies!");
    }

    public void showLocationInfo() {
        System.out.println("You are at: " + name);
        if (enemies.isEmpty()) {
            System.out.println("No enemies here.");
        } else {
            System.out.println("Enemies in " + name + ":");
            for (Enemy enemy : enemies) {
                System.out.println("- " + enemy.getClass().getSimpleName());
            }
        }
    }
}
