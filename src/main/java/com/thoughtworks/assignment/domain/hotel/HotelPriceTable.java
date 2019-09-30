package com.thoughtworks.assignment.domain.hotel;

import com.thoughtworks.assignment.domain.client.ClientClassification;
import com.thoughtworks.assignment.domain.stayDate.StayDate;
import com.thoughtworks.assignment.domain.stayDate.StayDateClassification;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class HotelPriceTable {

    private Map<PriceKey, Double> prices = new HashMap<>();

    public void addPrice(StayDateClassification dateClassification, ClientClassification clientClassification, Double value) {
        PriceKey priceKey = new PriceKey(dateClassification, clientClassification);
        prices.put(priceKey, value);
    }

    public void removePrice(StayDateClassification dateClassification, ClientClassification clientClassification) {
        PriceKey priceKey = new PriceKey(dateClassification, clientClassification);
        prices.remove(priceKey);
    }

    public Double getPrice(StayDateClassification dateClassification, ClientClassification clientClassification) {
        PriceKey priceKey = new PriceKey(dateClassification, clientClassification);
        return prices.get(priceKey);
    }

    public Integer size() {
        return this.prices.size();
    }

    private class PriceKey {

        private final StayDateClassification dateClassification;
        private final ClientClassification clientClassification;

        public PriceKey(StayDateClassification dateClassification, ClientClassification clientClassification) {
            this.dateClassification = dateClassification;
            this.clientClassification = clientClassification;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof PriceKey)) return false;
            PriceKey key = (PriceKey) o;
            return dateClassification == key.dateClassification && clientClassification == key.clientClassification;
        }

        @Override
        public int hashCode() {
            int result = dateClassification.hashCode();
            result = 31 * result + clientClassification.hashCode();
            return result;
        }
    }
}
