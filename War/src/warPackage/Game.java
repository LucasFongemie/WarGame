package warPackage;
import java.util.*;

public class Game {
    private Queue<Card> playerDeck;
    private Queue<Card> computerDeck;

    public Game() {
        Deck deck = new Deck();
        playerDeck = new LinkedList<Card>();
        computerDeck = new LinkedList<Card>();

        while (!deck.isEmpty()) {
            playerDeck.add(deck.drawCard());
            computerDeck.add(deck.drawCard());
        }
    }

    public void playRound() {
        if (playerDeck.isEmpty() || computerDeck.isEmpty()) return;

        Card playerCard = playerDeck.poll();
        Card computerCard = computerDeck.poll();

        System.out.println("Player: " + playerCard + " Computer: " + computerCard);

        if (playerCard.getRank() > computerCard.getRank()) {
            playerDeck.add(playerCard);
            playerDeck.add(computerCard);
        } else if (playerCard.getRank() < computerCard.getRank()) {
            computerDeck.add(playerCard);
            computerDeck.add(computerCard);
        }
        else
        {
        	if (playerCard.getRank() == computerCard.getRank()) {
           	 System.out.println("It's a tie.");
           	 if (playerDeck.size() < 4 || computerDeck.size() < 4) {
           		playerDeck.add(playerCard);
   	            computerDeck.add(computerCard);
           	 } else {
           	     List<Card> playerWarCards = new ArrayList<>();
           	     List<Card> computerWarCards = new ArrayList<>();

           	     for (int i = 0; i < 3; i++) {
           	         playerWarCards.add(playerDeck.poll());
           	         computerWarCards.add(computerDeck.poll());
           	     }

           	     Card playerWarCard = playerDeck.poll();
           	     Card computerWarCard = computerDeck.poll();

           	     if (playerWarCard.getRank() > computerWarCard.getRank()) {
           	         playerDeck.add(playerCard);
           	         playerDeck.addAll(playerWarCards);
           	         playerDeck.add(computerCard);
           	         playerDeck.addAll(computerWarCards);
           	      playerDeck.add(playerWarCard);
        	         playerDeck.add(computerWarCard);
           	         System.out.println("Player wins the war.");
           	     } else if (playerWarCard.getRank() < computerWarCard.getRank()) {
           	         computerDeck.add(playerCard);
           	         computerDeck.addAll(playerWarCards);
           	         computerDeck.add(computerCard);
           	         computerDeck.addAll(computerWarCards);
           	      computerDeck.add(playerWarCard);
        	         computerDeck.add(computerWarCard);
           	         System.out.println("Computer wins the war.");
           	     } else {
           	         System.out.println("Another tie.");
           	         playerDeck.add(playerCard);
        	         playerDeck.addAll(playerWarCards);
        	         computerDeck.add(computerCard);
        	         computerDeck.addAll(computerWarCards);
        	         playerDeck.add(playerWarCard);
        	         computerDeck.add(computerWarCard);
           	     }
           	 }
        	}
        	
        }
    }

    public boolean isGameOver() {
        return playerDeck.isEmpty() || computerDeck.isEmpty();
    }

    public void displayWinner() {
        if (playerDeck.isEmpty()) {
            System.out.println("Computer wins.");
        } else {
            System.out.println("Player wins.");
        }
    }
}