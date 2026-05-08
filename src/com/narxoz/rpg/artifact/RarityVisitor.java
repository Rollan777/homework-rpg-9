package com.narxoz.rpg.artifact;

/**
 * Fourth visitor proving open/closed behavior.
 * New report is added without editing artifact classes.
 */
public class RarityVisitor implements ArtifactVisitor {

    @Override
    public void visit(Weapon weapon) {
        printRarity(weapon);
    }

    @Override
    public void visit(Potion potion) {
        printRarity(potion);
    }

    @Override
    public void visit(Scroll scroll) {
        printRarity(scroll);
    }

    @Override
    public void visit(Ring ring) {
        printRarity(ring);
    }

    @Override
    public void visit(Armor armor) {
        printRarity(armor);
    }

    private void printRarity(Artifact artifact) {
        String rarity;

        if (artifact.getValue() >= 300) {
            rarity = "Legendary";
        } else if (artifact.getValue() >= 150) {
            rarity = "Rare";
        } else {
            rarity = "Common";
        }

        System.out.println("[Rarity] " + artifact.getName() + " is " + rarity);
    }
}