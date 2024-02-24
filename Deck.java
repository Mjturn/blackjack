import java.util.HashMap;

public class Deck {
    private String[] suits;
    private HashMap<String, Integer> values;
    private Card[] deck;

    public Deck() {
        suits = new String[] {"Clubs", "Diamonds", "Hearts", "Spades"};

        values = new HashMap<>() {{
            put("2", 2);
            put("3", 3);
            put("4", 4);
            put("5", 5);
            put("6", 6);
            put("7", 7);
            put("8", 8);
            put("9", 9);
            put("10", 10);
            put("Jack", 10);
            put("Queen", 10);
            put("King", 10);
            put("Ace", 1);
        }};

        deck = new Card[52];
    }

    public Card[] construct() {
        int index = 0;
        
         for(String suit : suits) {
            for(String value : values.keySet()) {
                deck[index] = new Card(suit, value);
                index++;
            }
        }

        return deck;
    }
}
