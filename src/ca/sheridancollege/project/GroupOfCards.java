/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author Group Project April 2024
 */


public class GroupOfCards {
    private ArrayList<BlackJackCard> cards; // Change to ArrayList<BlackJackCard>

    public GroupOfCards() {
        cards = new ArrayList<>();
    }

    public ArrayList<BlackJackCard> getCards() { // Change the return type
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public BlackJackCard drawCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("Deck is empty");
        }
        return cards.remove(0);
    }
}
