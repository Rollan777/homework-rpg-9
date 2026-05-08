package com.narxoz.rpg.artifact;

/**
 * Shows special power of each artifact type.
 */
public class PowerReportVisitor implements ArtifactVisitor {

    @Override
    public void visit(Weapon weapon) {
        System.out.println("[Power] " + weapon.getName()
                + " increases attack by " + weapon.getAttackBonus());
    }

    @Override
    public void visit(Potion potion) {
        System.out.println("[Power] " + potion.getName()
                + " restores " + potion.getHealing() + " HP");
    }

    @Override
    public void visit(Scroll scroll) {
        System.out.println("[Power] " + scroll.getName()
                + " contains spell: " + scroll.getSpellName());
    }

    @Override
    public void visit(Ring ring) {
        System.out.println("[Power] " + ring.getName()
                + " gives magic bonus " + ring.getMagicBonus());
    }

    @Override
    public void visit(Armor armor) {
        System.out.println("[Power] " + armor.getName()
                + " increases defense by " + armor.getDefenseBonus());
    }
}