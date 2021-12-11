import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public final class Player {
    private  Stack<Card> hand = new Stack<Card>();

    private Stack<Card> newHand = new Stack<Card>();



    private  Stack<Card> warCard = new Stack<Card>();

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


    public Stack<Card> getWarCard() {
        return warCard;
    }

    public void setWarCard(Card warCard) {
        this.warCard.add(warCard);
    }
    public Stack<Card> getNewHand() {
        return newHand;
    }
    public void setHand(Card ob){
        hand.add(ob);
    }
    public void setNewHand(Card ob ){
        newHand.add(ob);
    }

    public String getCardSuit() {
        if (this.hand.size() == 0){
            return newHand.get(getSizeNewHand() - 1).getSuitName();
        }
        return hand.peek().getSuitName();
    }

    public String getCardValue() {
        if (hand.size() == 0){
            return newHand.get(getSizeNewHand() - 1).getValue();
        }
        return hand.peek().getValue();
    }

    public Card flip() {
        if (this.hand.size() == 0){
           return newHand.peek();
        }
        return hand.peek();
    }

    public Card discard(){
        if (this.hand.size() == 0){
            return newHand.pop();
        }
        return hand.pop();
    }

    public int getSizeHand(){
        return hand.size();
    }

    public int getSizeNewHand(){
        return newHand.size();
    }
}
