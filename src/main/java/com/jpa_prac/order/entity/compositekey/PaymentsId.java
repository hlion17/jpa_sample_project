package com.jpa_prac.order.entity.compositekey;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PaymentsId implements Serializable {
    private String customerNumber;
    private String checkNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentsId paymentId = (PaymentsId) o;
        return Objects.equals(customerNumber, paymentId.customerNumber) && Objects.equals(checkNumber, paymentId.checkNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerNumber, checkNumber);
    }

    @Override
    public String toString() {
        return "PaymentsId{" +
                "customerNumber='" + customerNumber + '\'' +
                ", checkNumber='" + checkNumber + '\'' +
                '}';
    }
}
