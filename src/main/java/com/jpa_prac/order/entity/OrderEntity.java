package com.jpa_prac.order.entity;

import com.jpa_prac.customer.entity.CustomerEntity;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
@Getter
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue
    @Column(name = "orderNumber")
    private Long id;
    private LocalDate orderDate;
    private LocalDate requiredDate;
    private LocalDate shippedDate;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private String comments;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "customerNumber")
    private CustomerEntity customer;
    @OneToMany(fetch = LAZY, mappedBy = "order")
    private List<OrderDetailEntity> orderDetails = new ArrayList<>();

    // 고객 연관관계
    public void setCustomer(CustomerEntity customer) {
        if (this.customer != null) {
            this.customer.getOrders().remove(this);
        }
        this.customer = customer;
        this.customer.getOrders().add(this);
    }

    // 주문상세내역 연관관계
    public void setOrderDetails(OrderDetailEntity orderDetail) {
        this.orderDetails.add(orderDetail);
        orderDetail.setOrder(this);
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", requiredDate=" + requiredDate +
                ", shippedDate=" + shippedDate +
                ", comments='" + comments + '\'' +
                '}';
    }
}
