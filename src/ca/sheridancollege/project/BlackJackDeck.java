/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author GroupProject
 */


public class BlackJackDeck extends GroupOfCards {
    public BlackJackDeck() {
        for (String suit : new String[] { "Hearts", "Diamonds", "Clubs", "Spades" }) {
            for (String rank : new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King","Ace" }) {
                this.getCards().add(new BlackJackCard(rank, suit));
            }
        }
    }

    @Override
    public BlackJackCard drawCard() {
        if (this.getCards().isEmpty()) {
            throw new IllegalStateException("Deck is empty");
        }
        return this.getCards().remove(0);
    }
}
