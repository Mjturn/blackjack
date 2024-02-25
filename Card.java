public class Card {
    private String suit;
    private String value;

    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String toString() {
        return String.format("%s of %s", value, suit);
    }
}
