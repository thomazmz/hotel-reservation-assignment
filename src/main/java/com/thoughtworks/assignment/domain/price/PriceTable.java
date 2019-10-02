package com.thoughtworks.assignment.domain.price;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class PriceTable {

    private Map<PriceKey, Double> prices = new HashMap<>();

    public void addPrice(DayType dayType, ClientType clientType, Double value) {
        PriceKey priceKey = new PriceKey(dayType, clientType);
        prices.put(priceKey, value);
    }

    public void removePrice(DayType dayType,
                            ClientType clientType) {
        PriceKey priceKey = new PriceKey(dayType, clientType);
        prices.remove(priceKey);
    }

    public Double getPrice(LocalDate date, ClientType clientDeterminator) {
        return getPrice(DayType.getType(date), clientDeterminator);
    }

    public Double getPrice(DayType dayType, ClientType clientDeterminator) {
        PriceKey priceKey = new PriceKey(dayType, clientDeterminator);
        return prices.get(priceKey);
    }

    public Integer size() {
        return this.prices.size();
    }

    private class PriceKey {

        private final DayType dateDeterminator;
        private final ClientType clientDeterminator;

        public PriceKey(DayType dateDeterminator, ClientType clientDeterminator) {
            this.dateDeterminator = dateDeterminator;
            this.clientDeterminator = clientDeterminator;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof PriceKey)) return false;
            PriceKey key = (PriceKey) o;
            return dateDeterminator == key.dateDeterminator && clientDeterminator == key.clientDeterminator;
        }

        @Override
        public int hashCode() {
            int result = dateDeterminator.hashCode();
            result = 31 * result + clientDeterminator.hashCode();
            return result;
        }
    }
}
