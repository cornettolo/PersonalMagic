package cardgame.cards;

import cardgame.AbstractCardEffect;
import cardgame.Card;
import cardgame.Effect;
import cardgame.Player;

/**
 * Created by mryolo on 16/03/16.
 */
public class Cancel implements Card {

    private class CancelEffect extends AbstractCardEffect{
        public CancelEffect(Player p, Card c){
            super(p,c);
        }

        @Override
        public void resolve() {

        }
    }

    @Override
    public Effect get_effect(Player owner) {
        return new CancelEffect(owner,this);
    }

    @Override
    public String name() {
        return "Cancel";
    }

    @Override
    public String type() {
        return "Instant";
    }

    @Override
    public String rule_text() {
        return name() + " counter target spell";
    }

    @Override
    public boolean isInstant() {
        return true;
    }
}