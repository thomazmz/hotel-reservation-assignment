package com.thoughtworks.assignment;

import com.thoughtworks.assignment.application.hotel.HotelService;
import com.thoughtworks.assignment.domain.client.ClientClassification;
import com.thoughtworks.assignment.domain.hotel.Hotel;
import com.thoughtworks.assignment.domain.hotel.HotelPriceTable;
import com.thoughtworks.assignment.domain.reservationDate.ReservationDate;
import com.thoughtworks.assignment.domain.reservationDate.ReservationDateClassification;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        HotelPriceTable lakewoodPriceTable = new HotelPriceTable();
        lakewoodPriceTable.addPrice(ReservationDateClassification.WEEK_DAY, ClientClassification.REGULAR, 110D);
        lakewoodPriceTable.addPrice(ReservationDateClassification.WEEK_DAY, ClientClassification.REWARDS, 80D);
        lakewoodPriceTable.addPrice(ReservationDateClassification.WEEKEND_DAY, ClientClassification.REGULAR, 90D);
        lakewoodPriceTable.addPrice(ReservationDateClassification.WEEKEND_DAY, ClientClassification.REWARDS, 80D);
        Hotel lakewood = new Hotel("Lakewood", 3D, lakewoodPriceTable);

        HotelPriceTable bridgewoodPriceTable = new HotelPriceTable();
        bridgewoodPriceTable.addPrice(ReservationDateClassification.WEEK_DAY, ClientClassification.REGULAR, 160D);
        bridgewoodPriceTable.addPrice(ReservationDateClassification.WEEK_DAY, ClientClassification.REWARDS, 110D);
        bridgewoodPriceTable.addPrice(ReservationDateClassification.WEEKEND_DAY, ClientClassification.REGULAR, 60D);
        bridgewoodPriceTable.addPrice(ReservationDateClassification.WEEKEND_DAY, ClientClassification.REWARDS, 50D);
        Hotel bridgewood = new Hotel("Bridgewood", 4D, bridgewoodPriceTable);

        HotelPriceTable ridgewoodPriceTable = new HotelPriceTable();
        ridgewoodPriceTable.addPrice(ReservationDateClassification.WEEK_DAY, ClientClassification.REGULAR, 220D);
        ridgewoodPriceTable.addPrice(ReservationDateClassification.WEEK_DAY, ClientClassification.REWARDS, 100D);
        ridgewoodPriceTable.addPrice(ReservationDateClassification.WEEKEND_DAY, ClientClassification.REGULAR, 150D);
        ridgewoodPriceTable.addPrice(ReservationDateClassification.WEEKEND_DAY, ClientClassification.REWARDS, 40D);
        Hotel ridgewood = new Hotel("Ridgewood", 5D, ridgewoodPriceTable);

        HotelService service = new HotelService();

        service.create(lakewood);
        service.create(bridgewood);
        service.create(ridgewood);

        ClientClassification clientClassification;
        List<ReservationDate> dates;

        System.out.println("TESTE 1");
        clientClassification = ClientClassification.REGULAR;
        dates = new ArrayList<>();
        dates.add(new ReservationDate(2009, Month.MARCH, 16));
        dates.add(new ReservationDate(2009, Month.MARCH, 17));
        dates.add(new ReservationDate(2009, Month.MARCH, 18));

        System.out.println(lakewood.getName() + ": " + lakewood.getTotalPrice(dates, clientClassification));
        System.out.println(bridgewood.getName() + ": " + bridgewood.getTotalPrice(dates, clientClassification));
        System.out.println(ridgewood.getName() + ": " + ridgewood.getTotalPrice(dates, clientClassification));
        System.out.println(service.getCheapestHotel(clientClassification, dates).getName());

        System.out.println("TESTE 2");
        clientClassification = ClientClassification.REGULAR;
        dates = new ArrayList<>();
        dates.add(new ReservationDate(2009, Month.MARCH, 20));
        dates.add(new ReservationDate(2009, Month.MARCH, 21));
        dates.add(new ReservationDate(2009, Month.MARCH, 22));

        System.out.println(lakewood.getName() + ": " + lakewood.getTotalPrice(dates, clientClassification));
        System.out.println(bridgewood.getName() + ": " + bridgewood.getTotalPrice(dates, clientClassification));
        System.out.println(ridgewood.getName() + ": " + ridgewood.getTotalPrice(dates, clientClassification));
        System.out.println(service.getCheapestHotel(clientClassification, dates).getName());

        System.out.println("TESTE 3");
        clientClassification = ClientClassification.REWARDS;
        dates = new ArrayList<>();
        dates.add(new ReservationDate(2009, Month.MARCH, 26));
        dates.add(new ReservationDate(2009, Month.MARCH, 27));
        dates.add(new ReservationDate(2009, Month.MARCH, 28));

        System.out.println(lakewood.getName() + ": " + lakewood.getTotalPrice(dates, clientClassification));
        System.out.println(bridgewood.getName() + ": " + bridgewood.getTotalPrice(dates, clientClassification));
        System.out.println(ridgewood.getName() + ": " + ridgewood.getTotalPrice(dates, clientClassification));
        System.out.println(service.getCheapestHotel(clientClassification, dates).getName());

    }

}
