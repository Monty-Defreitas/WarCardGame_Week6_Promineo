import java.util.ArrayList;
import java.util.List;

public final class Player {
    private final List<Card> hand = new ArrayList<Card>();
    int score;
    String name;

    public Player(String name) {
        this.name = name;
        score = 0; // increments the players score
    }

    public void describe() {
        for (Card h : hand) {
            System.out.println(this.name + " " + h);
        }
    }

    public void draw(Deck deck) {
        hand.add(0, deck.draw());
    }

    public String getCardSuit() {
        return hand.get(0).getSuitName();
    }

    public String getCardValue() {
        return hand.get(0).getValue();
    }

    public Card flip() {
        return hand.remove(0);
    }
}
