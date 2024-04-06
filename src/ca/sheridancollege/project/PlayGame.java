package ca.sheridancollege.project;

import java.util.Scanner;

public class PlayGame {
    public static void main(String[] args) {

        System.out.println("==========================================================================================================================");
        System.out.println("Welcome to Blackjack!");
        System.out.println("");
        System.out.println("Rules: You will be given 2 cards to start the game, choose whether to hit (draw a card) or stand (stay with current hand).");
        System.out.println("The objective of the game is to have a hand greater than the dealer but less than or equal to 21! Dealer must have >=17");
        System.out.println("===========================================================================================================================");

        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
        String playerName = "";

        while (playAgain) {
            // Create an instance of BlackJackGame
            BlackJackGame game = new BlackJackGame();

            if (playerName.isEmpty()) {

                System.out.print("Please enter your name: ");
                playerName = scanner.nextLine();
            }
            // Add the player to the game
            game.getPlayers().add(new BlackJackPlayer(playerName));

            // Start the game
            game.play();

            System.out.println("Do you want to play again? (yes/no)");
            String choice = scanner.nextLine().toLowerCase();

            if (!choice.equals("yes")) {
                playAgain = false;
            }
        }
    }
}
