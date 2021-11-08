public  class Card {

    //card values
    private final String value;
    private final String suitName;
    private final int number;


    public Card(String value, String suitName, int number) {
        this.value = value;
        this.suitName = suitName;
        this.number = number;
    }



    public String getSuitName() {
        return suitName;
    }

    public String getValue() {
        return value;
    }

    public int getNumber() {
        return number;
    }

    public String describe(){
        return getValue() + " of " + getSuitName();
    }

    /**
     * For debugging purposes, to check if deck is properly populated.
     * @return carvalue, suitname and number.
     * */


    @Override
    public String toString() {
        return "Card{" +
                "value ='" + value + '\'' +
                ", suitName='" + suitName + '\'' +
                ", number=" + number +
                '}';
    }
}
