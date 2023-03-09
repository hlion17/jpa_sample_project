package com.jpa_prac.customer.entity;

import com.jpa_prac.employee.entity.EmployeeEntity;
import com.jpa_prac.order.entity.OrderEntity;
import com.jpa_prac.order.entity.PaymentEntity;
import lombok.Getter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
@Getter
@Table(name = "customers")
public class CustomerEntity {
    @Id
    @GeneratedValue
    @Column(name = "customerNumber")
    private Long id;
    private String customerName;
    private String contactLastName;
    private String contactFirstName;
    private String phone;
    @Embedded
    private CustomerAddressVO customerAddress;
    private String country;
    private Double creditLimit;
    @OneToMany(mappedBy = "customer", fetch = LAZY)
    private List<OrderEntity> orders = new ArrayList<>();
    @OneToMany(fetch = LAZY, mappedBy = "customers")
    private List<PaymentEntity> payments = new ArrayList<>();
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "salesRepEmployeeNumber")
    private EmployeeEntity employee;

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", contactLastName='" + contactLastName + '\'' +
                ", contactFirstName='" + contactFirstName + '\'' +
                ", phone='" + phone + '\'' +
                ", customerAddress'" + customerAddress + '\'' +
                ", country='" + country + '\'' +
                ", creditLimit=" + creditLimit +
                '}';
    }
}
