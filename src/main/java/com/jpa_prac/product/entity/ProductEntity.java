package com.jpa_prac.product.entity;

import com.jpa_prac.order.entity.OrderDetailEntity;
import lombok.Getter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
@Table(name = "products")
@Getter
public class ProductEntity {
    @Id
    @Column(name = "productCode")
    private String id;
    private String productName;
    private String productScale;
    private String productVendor;
    private String productDescription;
    private Integer quantityInStock;
    private Double buyPrice;
    private Double MSRP;
    @OneToMany(mappedBy = "product", fetch = LAZY)
    private List<OrderDetailEntity> orderDetails = new ArrayList<>();
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "productLine")
    private ProductLineEntity productLine;

    @Override
    public String toString() {
        return "ProductEntity{" +
                "productCode='" + id + '\'' +
                ", productName='" + productName + '\'' +
                ", productScale='" + productScale + '\'' +
                ", productVendor='" + productVendor + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", quantityInStock=" + quantityInStock +
                ", buyPrice=" + buyPrice +
                ", MSRP=" + MSRP +
                '}';
    }
}
