package Lections.CardsWithPower_03;

public class Card {
    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return this.rank;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public int getCardPower(){
        int power = getRank().getRankValue() + getSuit().getSuitValue();
        return power;
    }
}
