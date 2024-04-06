/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Group Project
 */
import java.util.ArrayList;
import java.util.Scanner;



public class BlackJackPlayer extends Player {
    
    private ArrayList<BlackJackCard> hand;
    Scanner scanner = new Scanner(System.in);

    public BlackJackPlayer(String name) {
        super(name);
        hand = new ArrayList<>();
    }

    public void addToHand(BlackJackCard card) {
        hand.add(card);
    }

    public ArrayList<BlackJackCard> getHand() {
        return hand;
    }

    public void playBlackJack(BlackJackDeck deck) {
        
        while (true) {
            System.out.println("");
            System.out.print(getName() + "'s turn. Your current hand: " + hand);
            System.out.println("-------- Hand Total: " + calculateScore());
            System.out.println("=============================================");

            
            System.out.println("Do you want to hit or stand? (h/s)");
            String choice = scanner.nextLine().toLowerCase();

            if (choice.equals("h")) {
                BlackJackCard newCard = deck.drawCard();
                addToHand(newCard);
                System.out.println("You drew a card: " + newCard);
                if (calculateScore() > 21) {
                    System.out.println("You busted! Score: " + calculateScore());
                    break;
                }
            } else if (choice.equals("s")) {
                System.out.println("You chose to stand.");
                break;
            } else {
                System.out.println("Invalid choice. Please enter 'h' or 's'.");
            }
        }
    }

    public int calculateScore() {
        int score = 0;
        int numAces = 0;
        for (BlackJackCard card : hand) {
            if (card.getRank().equals("Ace")) {
                numAces++;
            } else if (card.getRank().equals("Jack") || card.getRank().equals("Queen")
                    || card.getRank().equals("King")) {
                score += 10;
            } else {
                score += Integer.parseInt(card.getRank());
            }
        }
        for (int i = 0; i < numAces; i++) {
            if (score + 11 <= 21) {
                score += 11;
            } else {
                score += 1;
            }
        }
        // If ace in hand 
        while (score > 21 && numAces > 0) {
            score -= 10;
            numAces--;
        }
        return score;
    }

}
