package Lections.CardsWithPower_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String cardRank = reader.readLine();
        String cardType = reader.readLine();
        Card card = new Card(Rank.valueOf(cardRank),Suit.valueOf(cardType));

        System.out.println(String.format("Card name: %s of %s; Card power: %d",card.getRank(),card.getSuit(),card.getCardPower()));
    }
}
