package Lections.CardsWithPower_03;

public enum Suit {
    CLUBS (0),
    DIAMONDS (13),
    HEARTS  (26),
    SPADES (39);
    private int suitValue;

    Suit(int suitValue) {
        this.suitValue = suitValue;
    }

    public int getSuitValue() {
        return suitValue;
    }
}
