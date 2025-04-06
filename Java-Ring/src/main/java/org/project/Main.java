package org.project;

import org.project.entity.Entity;
import org.project.entity.players.*;
import org.project.entity.enemies.*;
import org.project.location.Location;
import org.project.object.armors.*;
import org.project.object.consumables.*;
import org.project.object.weapons.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Enemy skeleton = new Skeleton(40, 0, new BoneClub());
        Enemy goblin = new Goblin(35, 0, new Dager());
        Enemy dragon = new Dragon(120, 50, new FireBreath());

        ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location("Farron Keep", new ArrayList<>(List.of(goblin))));
        locations.add(new Location("Catacombs of Carthus", new ArrayList<>(List.of(skeleton))));
        locations.add(new Location("Smouldering Lake", new ArrayList<>(List.of(dragon))));

        System.out.println("Choose your class: (1) Knight, (2) Assassin, (3) Wizard");
        int choice = scanner.nextInt();
        Player player;
        Flask flask;
        Posion posion;
        switch (choice) {
            case 1 -> {
                player = new Knight(110, 0, new Sword(), new KnightArmor(5, 2));
                flask = new Flask(15, 1);
                posion = new Posion(0, 0);
            }
            case 2 -> {
                player = new Assassin(60, 0, new ThrowingKnives(), new AssassinArmor(10, 3));
                flask = new Flask(12, 3);
                posion = new Posion(10, 4);
            }
            case 3 -> {
                player = new Wizard(50, 50, new Sword(), new WizardArmor(10, 4));
                flask = new Flask(10, 4);
                posion = new Posion(0, 0);

            }
            default -> {
                System.out.println("Invalid choice! Defaulting to Knight.");
                player = new Knight(110, 0, new Sword(), new KnightArmor(5, 2));
                flask = new Flask(15, 1);
                posion = new Posion(0, 0);
            }
        }

        System.out.println("You have chosen: " + player.getName());

        while (player.getCurrentHP() > 0) {
            System.out.println("\nChoose a location:");
            for (int i = 0; i < locations.size(); i++) {
                System.out.println((i + 1) + ". " + locations.get(i).getName());
            }
            int locChoice = scanner.nextInt();

            if (locChoice < 1 || locChoice > locations.size()) {
                System.out.println("Invalid choice, returning to town.");
                continue;
            }

            Location selectedLocation = locations.get(locChoice - 1);
            Enemy enemy = selectedLocation.getEnemies().get(0);

            if(enemy.getCurrentHP() > 0 && player.getCurrentHP() > 0){
                System.out.println("A wild " + enemy.getName() + " appears!");
            }

            int roundCounter = 0;
            while (enemy.getCurrentHP() > 0 && player.getCurrentHP() > 0) {
                player.attack(enemy);
                System.out.println("Choose an action: (1) Special Ability, (2) Heal, (3) Add Mana");
                int action = scanner.nextInt();
                if(action == 1 && !(roundCounter % 3 == 0)) {
                    System.out.println("Special Ability is on cooldown!");
                    System.out.println("Choose another action: (2) Heal, (3) Add Mana");
                    action = scanner.nextInt();
                }

                if (action == 1) {
                    player.specialAbility(enemy);
                } else if (action == 2) {
                    flask.use(player);
                } else if (action == 3) {
                    posion.use(player);
                }

                if (enemy.getCurrentHP() > 0) {
                    enemy.attack(player);
                }
                roundCounter++;
            }

            if (player.getCurrentHP() > 0) {
                System.out.println("You defeated " + enemy.getName() + "!");
            } else {
                System.out.println("You have been defeated...");
                break;
            }
        }

        System.out.println("Game Over!");
        scanner.close();
    }
}
