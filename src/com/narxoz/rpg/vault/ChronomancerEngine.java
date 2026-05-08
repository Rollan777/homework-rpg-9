package com.narxoz.rpg.vault;

import com.narxoz.rpg.artifact.Armor;
import com.narxoz.rpg.artifact.Inventory;
import com.narxoz.rpg.artifact.Potion;
import com.narxoz.rpg.artifact.PowerReportVisitor;
import com.narxoz.rpg.artifact.RarityVisitor;
import com.narxoz.rpg.artifact.Ring;
import com.narxoz.rpg.artifact.Scroll;
import com.narxoz.rpg.artifact.ValueAppraisalVisitor;
import com.narxoz.rpg.artifact.Weapon;
import com.narxoz.rpg.artifact.WeightReportVisitor;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.combatant.HeroMemento;
import com.narxoz.rpg.memento.Caretaker;

import java.util.List;

/**
 * Orchestrates the Chronomancer's Vault demo run.
 */
public class ChronomancerEngine {

    public VaultRunResult runVault(List<Hero> party) {
        System.out.println();
        System.out.println("=== Chronomancer's Vault sequence started ===");

        if (party == null || party.isEmpty()) {
            System.out.println("No heroes entered the vault.");
            return new VaultRunResult(0, 0, 0);
        }

        Hero hero = party.get(0);
        Caretaker caretaker = new Caretaker();

        Inventory vaultInventory = createVaultInventory();

        System.out.println();
        System.out.println("--- Visitor pattern: artifact appraisal begins ---");

        ValueAppraisalVisitor valueVisitor = new ValueAppraisalVisitor();
        WeightReportVisitor weightVisitor = new WeightReportVisitor();
        PowerReportVisitor powerVisitor = new PowerReportVisitor();
        RarityVisitor rarityVisitor = new RarityVisitor();

        vaultInventory.accept(valueVisitor);
        vaultInventory.accept(weightVisitor);
        vaultInventory.accept(powerVisitor);
        vaultInventory.accept(rarityVisitor);

        System.out.println("--- Visitor pattern: artifact appraisal finished ---");
        System.out.println("Total artifact value: " + valueVisitor.getTotalValue());
        System.out.println("Total artifact weight: " + weightVisitor.getTotalWeight());

        System.out.println();
        System.out.println("--- Memento pattern: saving hero state ---");
        System.out.println("Before snapshot: " + hero);

        HeroMemento snapshot = hero.createMemento();
        caretaker.save(snapshot);

        System.out.println("Snapshot saved. Caretaker size: " + caretaker.size());

        System.out.println();
        System.out.println("--- Vault trap activated ---");
        hero.takeDamage(45);
        hero.spendMana(10);
        hero.spendGold(25);
        hero.setInventory(vaultInventory.copy());

        System.out.println("After trap and inventory change: " + hero);
        System.out.println("Inventory size after trap: " + hero.getInventory().size());

        System.out.println();
        System.out.println("--- Rewinding time with memento ---");

        HeroMemento previousState = caretaker.undo();

        int restoredCount = 0;

        if (previousState != null) {
            hero.restoreFromMemento(previousState);
            restoredCount++;
        }

        System.out.println("After rewind: " + hero);
        System.out.println("Inventory size after rewind: " + hero.getInventory().size());

        System.out.println("=== Chronomancer's Vault sequence finished ===");

        return new VaultRunResult(
                valueVisitor.getCount(),
                1,
                restoredCount
        );
    }

    private Inventory createVaultInventory() {
        Inventory vaultInventory = new Inventory();

        vaultInventory.addArtifact(new Weapon(
                "Blade of Echoes",
                220,
                8,
                15
        ));

        vaultInventory.addArtifact(new Potion(
                "Crystal Healing Potion",
                80,
                1,
                30
        ));

        vaultInventory.addArtifact(new Scroll(
                "Scroll of Time Freeze",
                300,
                1,
                "Time Freeze"
        ));

        vaultInventory.addArtifact(new Ring(
                "Ring of Mana",
                180,
                1,
                12
        ));

        vaultInventory.addArtifact(new Armor(
                "Chrono Plate Armor",
                260,
                15,
                20
        ));

        return vaultInventory;
    }
}