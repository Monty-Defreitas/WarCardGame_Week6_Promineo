public class Application {

  static String winner = " ";
    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println("Making the deck...");
        Player draws = new Player("Draws");
        Player one = new Player("Player1");
        Player two = new Player("Player2");




        System.out.println("Shuffling the Deck...");
        deck.shuffle();

        for (int i = 0; i < 52; i++){
            one.draw(deck);
        }


        for (int i = 0; i < 26; i++){

            System.out.println(one.name + " Draws: " + one.getCardValue() + " of " + one.getCardSuit());
            int oneNum = one.flip().getNumber();
            System.out.print("\t" + two.name + " Draws: " + one.getCardValue() + " of " + one.getCardSuit() + "\n");
            int twoNum = two.flip().getNumber();

            if (oneNum > twoNum){
                one.score ++;

                System.out.println("\t" + "\t" + "[" + one.name + "] Wins");

            }  else if (twoNum > oneNum) {
                two.score ++;

                System.out.println("\t" + "\t" +"[" + two.name + "] Wins");
            } else {
               draws.score++;
            }
        }
        System.out.println(one.name + " with " + one.score + " wins");
        System.out.println(two.name + " with " + two.score +  " wins");
        System.out.println("Times tied: " + draws.score);

        if (one.score > two.score) {
            System.out.println(one.name + " wins the game with a score of " + one.score);
        }
        else if(one.score < two.score) {
            System.out.println(two.name + " wins the game with a score of: " + two.score);
        }
        else {
            System.out.println(one.name + " ties with " + two.name);
        }

    }
}
