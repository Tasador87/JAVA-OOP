package Lections.HotelReservation_04;

public enum DiscountType {
    VIP(20),
    SECONDVISIT(10),
    NONE(0);

    private int discountValue;

    DiscountType(int discountValue) {
        this.discountValue = discountValue;
    }

    public int getDiscountValue() {
        return discountValue;
    }
}
