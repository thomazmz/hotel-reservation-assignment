package com.thoughtworks.assignment.domain;

import java.util.Date;
import java.util.Map;

public class HotelTaxTable {

    private Map<TaxKey, Double> taxes;

    public void addPrice(DateType dateType, ClientType clientType, Double value) {
        TaxKey taxKey = new TaxKey(dateType, clientType);
        taxes.put(taxKey, value);
    }

    public void removePrice(DateType dateType, ClientType clientType) {
        TaxKey taxKey = new TaxKey(dateType, clientType);
        taxes.remove(taxKey);
    }

    public Double getPrice(Date date, ClientType clientType) {
        return getPrice(DateType.getType(date), clientType);
    }

    public Double getPrice(DateType dateType, ClientType clientType) {
        TaxKey taxKey = new TaxKey(dateType, clientType);
        return taxes.get(taxKey);
    }

    private class TaxKey {

        private final DateType dateType;
        private final ClientType clientType;

        public TaxKey(DateType dateType, ClientType clientType) {
            this.dateType = dateType;
            this.clientType = clientType;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof TaxKey)) return false;
            TaxKey key = (TaxKey) o;
            return dateType == key.dateType && clientType == key.clientType;
        }

        @Override
        public int hashCode() {
            int result = dateType.hashCode();
            result = 31 * result + clientType.hashCode();
            return result;
        }
    }
}
