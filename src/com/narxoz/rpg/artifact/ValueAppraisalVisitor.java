package com.narxoz.rpg.artifact;

/**
 * Calculates the total gold value of all artifacts.
 */
public class ValueAppraisalVisitor implements ArtifactVisitor {

    private int totalValue;
    private int count;

    @Override
    public void visit(Weapon weapon) {
        totalValue += weapon.getValue();
        count++;
        System.out.println("[Value] Weapon: " + weapon.getName()
                + " | value=" + weapon.getValue()
                + " | attackBonus=" + weapon.getAttackBonus());
    }

    @Override
    public void visit(Potion potion) {
        totalValue += potion.getValue();
        count++;
        System.out.println("[Value] Potion: " + potion.getName()
                + " | value=" + potion.getValue()
                + " | healing=" + potion.getHealing());
    }

    @Override
    public void visit(Scroll scroll) {
        totalValue += scroll.getValue();
        count++;
        System.out.println("[Value] Scroll: " + scroll.getName()
                + " | value=" + scroll.getValue()
                + " | spell=" + scroll.getSpellName());
    }

    @Override
    public void visit(Ring ring) {
        totalValue += ring.getValue();
        count++;
        System.out.println("[Value] Ring: " + ring.getName()
                + " | value=" + ring.getValue()
                + " | magicBonus=" + ring.getMagicBonus());
    }

    @Override
    public void visit(Armor armor) {
        totalValue += armor.getValue();
        count++;
        System.out.println("[Value] Armor: " + armor.getName()
                + " | value=" + armor.getValue()
                + " | defenseBonus=" + armor.getDefenseBonus());
    }

    public int getTotalValue() {
        return totalValue;
    }

    public int getCount() {
        return count;
    }
}