package com.jpa_prac.order.entity;

import com.jpa_prac.order.entity.compositekey.OrderDetailId;
import com.jpa_prac.product.entity.ProductEntity;
import lombok.Getter;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter
@Table(name = "orderdetails")
public class OrderDetailEntity {
    @EmbeddedId
    private OrderDetailId id;
    private Integer quantityOrdered;
    private Double priceEach;
    private Integer orderLineNumber;
    @MapsId("orderNumber")
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "orderNumber")
    private OrderEntity order;
    @MapsId("productCode")
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "productCode")
    private ProductEntity product;

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderDetailEntity{" +
                "id=" + id +
                ", quantityOrdered=" + quantityOrdered +
                ", priceEach=" + priceEach +
                ", orderLineNumber=" + orderLineNumber +
                '}';
    }
}
