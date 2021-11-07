public final class Card {

    //card values
    private final String cardValue;
    private final String suitName;
    private final int number;


    public Card(String cardValue, String suitName, int number) {
        this.cardValue = cardValue;
        this.suitName = suitName;
        this.number = number;
    }



    public String getSuitName() {
        return suitName;
    }

    public String getCardValue() {
        return cardValue;
    }

    public int getNumber() {
        return number;
    }

    public String describe(){
        return getCardValue() + " of " + getSuitName();
    }

    /**
     * For debugging purposes, to check if deck is properly populated.
     * @return carvalue, suitname and number.
     * */


    @Override
    public String toString() {
        return "Card{" +
                "cardValue ='" + cardValue + '\'' +
                ", suitName='" + suitName + '\'' +
                ", number=" + number +
                '}';
    }
}
