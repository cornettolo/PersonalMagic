package cardgame.cards;

import cardgame.AbstractCardEffect;
import cardgame.Card;
import cardgame.Effect;
import cardgame.Player;

/**
 * Created by Kotono on 16/03/2016.
 */
public class Deflection implements Card {

    private class DeflectionEffect extends AbstractCardEffect {
        public DeflectionEffect(Player p, Card c){
            super(p,c);
        }

        @Override
        public void resolve() {

        }
    }

    @Override
    public Effect get_effect(Player owner) {
        return new DeflectionEffect(owner,this);
    }

    @Override
    public String name() {
        return "Deflection";
    }

    @Override
    public String type() {
        return "Instant";
    }

    @Override
    public String rule_text() {
        return "Change the target of target spell with a single target";
    }

    @Override
    public boolean isInstant() {
        return true;
    }
}
