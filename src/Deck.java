import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Deck {

    private static final List<String> cardValue = List.of("2", "3", "4", "5", "6",
            "7", "8", "9", "10", "Jack", "Queen", "King", "Ace");

    private static final List<String> suitNames = List.of("Clubs", "Diamonds", "Hearts", "Spades");


    private static final List<Card> cards = new ArrayList<Card>();

    public Deck() {

        for (int i = 0; i < cardValue.size(); i++) {
            String value = cardValue.get(i);
            int number = i + 2;
            for (String suitName : suitNames) {
                cards.add(new Card(value, suitName, number));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        return cards.remove(0);

    }
}