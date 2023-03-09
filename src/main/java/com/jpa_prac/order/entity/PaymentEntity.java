package com.jpa_prac.order.entity;

import com.jpa_prac.customer.entity.CustomerEntity;
import com.jpa_prac.order.entity.compositekey.PaymentsId;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.FetchType.*;

@Entity
@Table(name = "payments")
@Getter
public class PaymentEntity {
    @EmbeddedId
    private PaymentsId id;
    private LocalDate paymentDate;
    private Double amount;
    @MapsId("customerNumber")
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "customerNumber")
    private CustomerEntity customers;

    @Override
    public String toString() {
        return "PaymentEntity{" +
                "id=" + id +
                ", paymentDate=" + paymentDate +
                ", amount=" + amount +
                '}';
    }
}




