package com.narxoz.rpg;

import com.narxoz.rpg.artifact.Inventory;
import com.narxoz.rpg.artifact.Potion;
import com.narxoz.rpg.artifact.Ring;
import com.narxoz.rpg.artifact.Weapon;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.vault.ChronomancerEngine;
import com.narxoz.rpg.vault.VaultRunResult;

import java.util.List;

/**
 * Entry point for Homework 9 — Chronomancer's Vault: Visitor + Memento.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== Homework 9 Demo: Visitor + Memento ===");

        Inventory warriorInventory = new Inventory();
        warriorInventory.addArtifact(new Weapon(
                "Training Sword",
                50,
                5,
                5
        ));
        warriorInventory.addArtifact(new Potion(
                "Small Potion",
                25,
                1,
                10
        ));

        Inventory mageInventory = new Inventory();
        mageInventory.addArtifact(new Ring(
                "Apprentice Ring",
                70,
                1,
                5
        ));

        Hero warrior = new Hero(
                "Arman the Warrior",
                120,
                20,
                18,
                8,
                100,
                warriorInventory
        );

        Hero mage = new Hero(
                "Dana the Mage",
                80,
                50,
                10,
                4,
                150,
                mageInventory
        );

        System.out.println();
        System.out.println("Party created:");
        System.out.println(warrior);
        System.out.println(mage);

        ChronomancerEngine engine = new ChronomancerEngine();
        VaultRunResult result = engine.runVault(List.of(warrior, mage));

        System.out.println();
        System.out.println("Final result:");
        System.out.println(result);
    }
}