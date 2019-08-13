package Lections.HotelReservation_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] holidayInformation = reader.readLine().split("\\s+");
        //“<pricePerDay> <numberOfDays> <season> <discountType>”

        double pricePerDay = Double.parseDouble(holidayInformation[0]);
        int numberOfDays = Integer.parseInt(holidayInformation[1]);
        Season season = Season.valueOf(holidayInformation[2].toUpperCase());
        String discountType = holidayInformation[3].toUpperCase();

        PriceCalculator priceCalculator = new PriceCalculator(pricePerDay,numberOfDays,season,DiscountType.valueOf(discountType));
        System.out.println(String.format("%.2f",priceCalculator.calculate()));
    }
}