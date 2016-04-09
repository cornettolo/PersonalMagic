package cardgame.cards;

import cardgame.*;


public class BoilingEarth implements Card {

    private class BoilingEarthEffect extends AbstractCardEffect {
        public BoilingEarthEffect(Player p, Card c){
            super(p,c);
        }


        @Override
        public void setTarget() {
        }

        @Override
        public boolean hasTarget() {
            return false;
        }

        @Override
        public void resolve() {
            for (Creature c: opponent.get_creatures()) {
                c.inflict_damage(1); //ConcurrentModificationException se faccio danno a una creatura con 1 di toughness
            }
        }
    }

    @Override
    public Effect get_effect(Player owner) {
        return new BoilingEarthEffect(owner,this);
    }

    @Override
    public String name() {
        return "Boiling Earth";
    }

    @Override
    public String type() {
        return "Sorcery";
    }

    @Override
    public String rule_text() {
        return "Boiling Earth deals 1 damage to each creature";
    }

    @Override
    public boolean isInstant() {
        return false;
    }

    public String toString() { return name() + "[" + rule_text() +"]";}
}
