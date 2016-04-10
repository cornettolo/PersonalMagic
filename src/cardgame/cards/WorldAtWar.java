package cardgame.cards;

import cardgame.*;

/**
 * Created by Kotono on 16/03/2016.
 */
public class WorldAtWar implements Card {

    private class WorldAtWarEffect extends AbstractCardEffect {
        public WorldAtWarEffect(Player p, Card c) {
            super(p, c);
        }

        @Override
        public boolean setTarget() {
            return false;
        }

        @Override
        public boolean hasTarget() {
            return false;
        }

        @Override
        public void resolve() {
            //TODO non va un cazzo bene

            //dopo main
            CardGame.instance.get_triggers().register(8, new TriggerAction() {


                @Override
                public void execute() {
                    for (Creature c : owner.get_creatures()) {
                        if (c.getIsAttacking() == true) c.tap();
                    }
                    for (Creature c : opponent.get_creatures()) {
                        if (c.getIsAttacking() == true) c.tap();
                    }
                    owner.set_phase(Phases.COMBAT, new DefaultCombatPhase());
                    owner.set_phase(Phases.MAIN, new DefaultMainPhase());
                }

            });


        }
    }


    @Override
    public Effect get_effect(Player owner) {
        return new WorldAtWarEffect(owner,this);
    }

    @Override
    public String name() {
        return "World at War";
    }

    @Override
    public String type() {
        return "Sorcery";
    }

    @Override
    public String rule_text() {
        return "After the first postcombat main phase this turn, there's an additional combat phase followed by an additional main phase. At the beginning of that combat, untap all creatures that attacked this turn";
    }

    @Override
    public boolean isInstant() {
        return false;
    }

    public String toString() { return name() + "[" + rule_text() +"]";}
}
