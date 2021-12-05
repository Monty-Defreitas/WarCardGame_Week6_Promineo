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

        for (int i = 0; i < 52; i++) {
            one.draw(deck);
        }

        for (int i = 0; i < 26; i++) {
            System.out.print(one.name + " Drew: " + one.getCardValue() + " of " + one.getCardSuit());
            int oneNum = one.flip().getNumber();
            System.out.print("<--->");
            System.out.print(two.name + " Drew: " + one.getCardValue() + " of " + one.getCardSuit() + "\n");
            int twoNum = two.flip().getNumber();

            if (oneNum > twoNum) {
                one.score++;
                System.out.println("[" + one.name + "] Wins");

            } else if (twoNum > oneNum) {
                two.score++;
                System.out.println(builder2 + "[" + two.name + "] Wins");

            } else {
                System.out.println(builder3 + "[Draw, Fight harder!]");
                draws.score++;
            }
        }

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
