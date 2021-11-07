public class Application {

  static String winner = "";
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
            int oneNum = one.flip();
            int twoNum = two.flip();

            if (oneNum > twoNum){
                one.score ++;
                two.loses++;
            }  else if (twoNum > oneNum) {
                two.score ++;
                one.loses++;
            } else {
               draws.score++;
            }
        }
        System.out.println(one.name + " with " + one.score + " wins" + " & " + one.loses + " loses ");
        System.out.println(two.name + " with " + two.score +  " wins" + " & " + two.loses + " loses ");
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
