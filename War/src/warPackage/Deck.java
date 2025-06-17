package warPackage;
import java.util.*;

public class Deck {
    private Queue<Card> cards = new LinkedList<>();

    public Deck() {
        List<Card> tempDeck = new ArrayList<>();
        for (int rank = 2; rank <= 14; rank++) { 
            tempDeck.add(new Card(rank));
            tempDeck.add(new Card(rank));
            tempDeck.add(new Card(rank));
            tempDeck.add(new Card(rank));
        }
        Collections.shuffle(tempDeck);
        cards.addAll(tempDeck);
    }

    public Card drawCard() {
        return cards.poll();
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
}