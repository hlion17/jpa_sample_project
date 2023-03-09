package com.jpa_prac.product.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
@Table(name = "productlines")
@Getter
public class ProductLineEntity {
    @Id
    private String productLine;
    private String textDescription;
    private String htmlDescription;
    @Lob
    private byte[] image;
    @OneToMany(fetch = LAZY, mappedBy = "productLine")
    private List<ProductEntity> products = new ArrayList<>();

    @Override
    public String toString() {
        return "ProductLineEntity{" +
                "productLine='" + productLine + '\'' +
                ", textDescription='" + textDescription + '\'' +
                ", htmlDescription='" + htmlDescription + '\'' +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}
