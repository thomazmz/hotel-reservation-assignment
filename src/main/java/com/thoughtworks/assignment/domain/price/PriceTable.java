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

    public Double getPrice(LocalDate date, ClientType clientType) {
        return getPrice(DayType.getType(date), clientType);
    }

    public Double getPrice(DayType dayType, ClientType clientType) {
        PriceKey priceKey = new PriceKey(dayType, clientType);
        return prices.get(priceKey);
    }

    public Integer size() {
        return this.prices.size();
    }

    private class PriceKey {

        private final DayType dayType;
        private final ClientType clientType;

        public PriceKey(DayType dayType, ClientType clientType) {
            this.dayType = dayType;
            this.clientType = clientType;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof PriceKey)) return false;
            PriceKey key = (PriceKey) o;
            return dayType == key.dayType && clientType == key.clientType;
        }

        @Override
        public int hashCode() {
            int result = dayType.hashCode();
            result = 31 * result + clientType.hashCode();
            return result;
        }
    }
}
