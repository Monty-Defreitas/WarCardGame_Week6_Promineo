import java.util.ArrayList;
import java.util.List;
public final class Player {
        private static final List<Card> hand = new ArrayList<Card>();
        int score;
        int loses;
        String name;


        public Player(String name){
            this.name = name;
            score = 0; // increments the players score
        }
        public void describe(){
            for(Card h: hand){
                System.out.println(name + " " + h.describe());
            }
        }
        public void draw(Deck deck) {
            hand.add(0, deck.draw());
        }

        public int  flip(){
            return hand.remove(0).getNumber();
        }
}
