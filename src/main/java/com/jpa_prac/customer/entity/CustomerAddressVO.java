package com.jpa_prac.customer.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@ToString
@EqualsAndHashCode
public class CustomerAddressVO {
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
}
