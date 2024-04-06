package ca.sheridancollege.project;

public class BlackJackGame extends Game {

    private BlackJackDeck deck;
    private BlackJackPlayer dealer;

    public BlackJackGame() {
        super("BlackJack");
        deck = new BlackJackDeck();
        dealer = new BlackJackPlayer("Dealer");
    }

    public BlackJackDeck getDeck() {
        return deck;
    }

    @Override
    public void play() {
        // Shuffle the deck
        deck.shuffle();

        // Deal initial cards to players
        System.out.println("Game Started: Dealer deals cards");
        System.out.println("");
        for (Player player : getPlayers()) {
            BlackJackPlayer blackJackPlayer = (BlackJackPlayer) player;
            blackJackPlayer.addToHand(deck.drawCard());
            blackJackPlayer.addToHand(deck.drawCard());
        }
        dealer.addToHand(deck.drawCard());
        dealer.addToHand(deck.drawCard());

        // Show only 1 visible card from the dealer

        System.out.println("Dealer's hand : [Hidden Card, " + dealer.getHand().get(1) + "]");

        // Player's turn
        for (Player player : getPlayers()) {
            BlackJackPlayer blackJackPlayer = (BlackJackPlayer) player;
            blackJackPlayer.playBlackJack(deck);
        }

    
        // Dealer's turn: Show dealer's hidden card with hand

        System.out.println("");
        System.out.println("Dealer's turn: " + dealer.getHand());

        while (dealer.calculateScore() < 17) {
            BlackJackCard newCard = deck.drawCard();
            dealer.addToHand(newCard);
            System.out.println("Dealer drew a card: " + newCard);
        }

    
        System.out.println("=============================================");
        declareWinner();
    }

    @Override
    public void declareWinner() {
        int dealerScore = dealer.calculateScore();
        System.out.println("Dealer's hand " + dealer.getHand() + "--------Hand Total: " + dealerScore);

        for (Player player : getPlayers()) {
            BlackJackPlayer blackJackPlayer = (BlackJackPlayer) player;
            int playerScore = blackJackPlayer.calculateScore();

            System.out.println(player.getName() + "'s hand: " + blackJackPlayer.getHand() + "--------Hand Total: " + playerScore);

            if (playerScore > 21 || (dealerScore <= 21 && dealerScore > playerScore)) {

                System.out.println("");
                System.out.println(player.getName() + " loses.");

            } else if (playerScore == dealerScore) {

                System.out.println("");
                System.out.println(player.getName() + " ties with the dealer.");

            } else {

                System.out.println("");
                System.out.println(player.getName() + " wins!");

            }
        }
    }
}
