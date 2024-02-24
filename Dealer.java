import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Dealer {
    public static void deal() {
        Deck deck = new Deck();
        Card[] deckArray = deck.construct();
        
        Random random = new Random();
        
        int userCardIndex1 = random.nextInt(deckArray.length);
        int dealerCardIndex1 = random.nextInt(deckArray.length);
        int userCardIndex2 = random.nextInt(deckArray.length);
        
        Card userCard1 = deckArray[userCardIndex1];
        Card dealerCard1 = deckArray[dealerCardIndex1];
        Card userCard2 = deckArray[userCardIndex2];

        ArrayList<Card> userCards = new ArrayList<>();
        ArrayList<Card> dealerCards = new ArrayList<>();

        userCards.add(userCard1);
        userCards.add(userCard2);
        dealerCards.add(dealerCard1);
        
        System.out.println("User Cards:");
        for(int i = 0; i < userCards.size(); i++) {
            System.out.println(userCards.get(i));
        }

        System.out.println();
        
        System.out.println("Dealer Cards:");
        for(int i = 0; i < dealerCards.size(); i++) {
            System.out.println(dealerCards.get(i));
        }

        System.out.println();
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to hit or stay?");
        String hitOrStay = scanner.nextLine();

        while(!hitOrStay.equalsIgnoreCase("stay")) {
            if(hitOrStay.equalsIgnoreCase("hit")) {
                int userCardIndex = random.nextInt(deckArray.length);
                Card userCard = deckArray[userCardIndex];
                userCards.add(userCard);
            } else {
                System.out.println("Sorry, what you've entered is invalid. Please try again.");
            }

            System.out.println();
        
            System.out.println("User Cards:");
            for(int i = 0; i < userCards.size(); i++) {
                System.out.println(userCards.get(i));
            }

            System.out.println();

            System.out.println("Dealer Cards:");
            for(int i = 0; i < dealerCards.size(); i++) {
                System.out.println(dealerCards.get(i));
            }

            System.out.println();

            System.out.println("Would you like to hit or stay?");
            hitOrStay = scanner.nextLine();
        }

        System.out.println();

        System.out.println("User Cards:");
        for(int i = 0; i < userCards.size(); i++) {
            System.out.println(userCards.get(i));
        }

        System.out.println();

        System.out.println("Dealer Cards:");
        for(int i = 0; i < dealerCards.size(); i++) {
            System.out.println(dealerCards.get(i));
        }
    }
}
