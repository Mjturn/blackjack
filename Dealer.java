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
        int userTotal = 0;
        for(int i = 0; i < userCards.size(); i++) {
            System.out.println(userCards.get(i));
            userTotal += deck.getValues().get(userCards.get(i).getValue());
        }

        System.out.printf("User Total: %d", userTotal);
        System.out.println();
        System.out.println();

        System.out.println("Dealer Cards:");
        int dealerTotal = 0;
        for(int i = 0; i < dealerCards.size(); i++) {
            System.out.println(dealerCards.get(i));
            dealerTotal += deck.getValues().get(dealerCards.get(i).getValue());
        }

        System.out.printf("Dealer Total: %d", dealerTotal);
        System.out.println();
        System.out.println();
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to hit or stay?");
        String hitOrStay = scanner.nextLine();
            
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_ORANGE = "\u001B[38;5;208m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_RESET = "\u001B[0m";

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
            userTotal = 0;
            for(int i = 0; i < userCards.size(); i++) {
                System.out.println(userCards.get(i));
                userTotal += deck.getValues().get(userCards.get(i).getValue());
            }

            System.out.printf("User Total: %d", userTotal);
            System.out.println();
            System.out.println();

            System.out.println("Dealer Cards:");
            dealerTotal = 0;
            for(int i = 0; i < dealerCards.size(); i++) {
                System.out.println(dealerCards.get(i));
                dealerTotal += deck.getValues().get(dealerCards.get(i).getValue());
            }

            System.out.printf("Dealer Total: %d", dealerTotal);
            System.out.println();
            System.out.println();

            if(userTotal == 21) {
                System.out.println(ANSI_YELLOW + "Congratulations, you have won!" + ANSI_RESET);
                break;
            } else if(userTotal > 21) {
                System.out.println(ANSI_RED + "You have lost." + ANSI_RESET);
                break;
            }

            System.out.println("Would you like to hit or stay?");
            hitOrStay = scanner.nextLine();
        }
            
        if(userTotal < 21) {
            while(dealerTotal <= 16) {
                int dealerCardIndex = random.nextInt(deckArray.length);
                Card dealerCard = deckArray[dealerCardIndex];
                dealerCards.add(dealerCard);
                dealerTotal += deck.getValues().get(dealerCard.getValue());
            }
        }
        
        System.out.println();

        if(dealerTotal > 21) {
            System.out.println(ANSI_YELLOW + "Congratulations, you have won!" + ANSI_RESET);
        }

        if(userTotal < 21 && userTotal > dealerTotal) {
            System.out.println(ANSI_YELLOW + "Congratulations, you have won!" + ANSI_RESET);
        } else if(dealerTotal <= 21 && userTotal < dealerTotal) {
            System.out.println(ANSI_RED + "You have lost." + ANSI_RESET);
        } else if(userTotal == dealerTotal) {
            System.out.println(ANSI_ORANGE + "You have tied with the dealer." + ANSI_RESET);
        }

        System.out.println();

        System.out.println("User Cards:");
        for(int i = 0; i < userCards.size(); i++) {
            System.out.println(userCards.get(i));
        }
        
        System.out.printf("User Total: %d", userTotal);
        System.out.println();
        System.out.println();

        System.out.println("Dealer Cards:");
        for(int i = 0; i < dealerCards.size(); i++) {
            System.out.println(dealerCards.get(i));
        }

        System.out.printf("Dealer Total: %d", dealerTotal);
        System.out.println();
        System.out.println();
    }
}
