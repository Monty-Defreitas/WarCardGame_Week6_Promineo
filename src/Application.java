import java.util.Collections;

public class Application {


    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println("Making the deck...");
        Player draws = new Player("Draws");
        Player one = new Player("Monty");
        Player two = new Player("Eli");
        String p1P2 = "\t" + "\t" + "[" + one.name + "] Wins";

        StringBuilder builder2 = new StringBuilder();
        for (int i = 0; i < p1P2.length() * 2; i++) {
            builder2.append(" ");
        }
        StringBuilder builder3 = new StringBuilder();
        for (int i = 0; i < 7 * 2; i++) {
            builder3.append(" ");
        }

        System.out.println("Shuffling the Deck...");
        deck.shuffle();

        for (int i = 0; i < 26; i++) {
            one.draw(deck);
            two.draw(deck);
        }


        do {
            for (int i = 0; i < one.getSizeHand() || i < one.getSizeNewHand() || i < two.getSizeHand() || i < two.getSizeNewHand(); i++) {
                if (one.getSizeHand() == 0){
                    Collections.shuffle(one.getNewHand());

                    System.out.print(one.name + " Drew: " + one.flip().getValue() + " of " + one.flip().getSuitName() + "\n");
                } else {
                    System.out.print(one.name + " Drew: " + one.getCardValue() + " of " + one.getCardSuit() + "\n");
                }
                int oneNum = one.flip().getNumber();
                System.out.print("<--->");
                if (two.getSizeHand() == 0){
                    Collections.shuffle(two.getNewHand());
                    System.out.print(two.name + " Drew: " + two.getCardValue() + " of " + two.getCardSuit() + "\n");
                } else {
                    System.out.print(two.name + " Drew: " + two.getCardValue() + " of " + two.getCardSuit() + "\n");
                }
                int twoNum = two.flip().getNumber();

                if (oneNum > twoNum) {
                    if(one.getSizeHand() != 0) {
                        one.setNewHand(two.discard());
                        one.setNewHand(one.discard());
                    } else {
                        one.setHand(two.discard());
                        one.setHand(one.discard());
                    }
                    one.score++;
                    System.out.println("[" + one.name + "] Wins" + one.score);

                } else if (twoNum > oneNum) {
                    if (two.getSizeHand() != 0) {
                        two.setNewHand(one.discard());
                        two.setNewHand(two.discard());
                    } else {
                        two.setHand(one.discard());
                        two.setHand(two.discard());
                    }
                    two.score++;
                    System.out.println(builder2 + "[" + two.name + "] Wins" + two.score);

                } else {
                    for (int j = 0; j < 3; j++){
                        one.setWarCard(one.discard());
                        two.setWarCard(two.discard());
                    }
                    int oneWar = one.flip().getNumber();
                    int twoWar = two.flip().getNumber();

                    if (oneWar > twoWar) {
                        if(one.getSizeHand() != 0) {
                                for (int k = 0; k < one.getWarCard().size(); k++) {
                                    one.setNewHand(one.getWarCard().pop());
                                    one.setNewHand(two.getWarCard().pop());
                                }
                                one.setNewHand(two.discard());
                                one.setNewHand(one.discard());
                        } else {
                            for (int l = 0; l < one.getWarCard().size(); l++){
                                one.setHand(one.getWarCard().pop());
                                one.setHand(two.getWarCard().pop());
                            }
                            one.setHand(two.discard());
                            one.setHand(one.discard());
                        }
                    }
                    if (oneWar < twoWar) {
                        if(two.getSizeHand() != 0) {
                        for (int k = 0; k < two.getWarCard().size(); k++) {
                            two.setNewHand(two.getWarCard().pop());
                            two.setNewHand(one.getWarCard().pop());
                        }
                        two.setNewHand(one.discard());
                        two.setNewHand(two.discard());
                    } else {
                        for (int l = 0; l < two.getWarCard().size(); l++){
                            two.setHand(two.getWarCard().pop());
                            two.setHand(one.getWarCard().pop());
                        }
                        two.setHand(one.discard());
                        two.setHand(two.discard());
                    }
                    }

                    /*if (one.getSizeHand() !=0 && two.getSizeHand() != 0) {
                        two.setNewHand(two.discard());
                        one.setNewHand(one.discard());
                    } else {
                        two.setHand(two.discard());
                        one.setHand(one.discard());
                    }*/
                    System.out.println(builder3 + "[Draw, Fight harder!]" + draws.score);
                    draws.score++;
                }
            }


        }while(one.getNewHand().size() != 0 && one.getSizeHand() != 0 || two.getNewHand().size() != 0 && two.getSizeHand() != 0);


        System.out.println(one.name + " with " + one.score + " wins");
        System.out.println(two.name + " with " + two.score + " wins");
        System.out.println("Times tied: " + draws.score);

        if (one.score > two.score) {
            System.out.println(one.name + " wins the game with a score of " + one.score);
        } else if (one.score < two.score) {
            System.out.println(two.name + " wins the game with a score of: " + two.score);
        } else {
            System.out.println(one.name + " ties with " + two.name);
        }


    }
}
