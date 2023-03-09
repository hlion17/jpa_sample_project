package com.jpa_prac.office.entity;

import com.jpa_prac.employee.entity.EmployeeEntity;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
@Table(name = "offices")
@Getter
public class OfficeEntity {
    @Id
    @Column(name = "officeCode")
    private String id;
    private String city;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String state;
    private String country;
    private String postalCode;
    private String territory;
    @OneToMany(fetch = LAZY, mappedBy = "office")
    private List<EmployeeEntity> employees = new ArrayList<>();

    @Override
    public String toString() {
        return "OfficeEntity{" +
                "officeCode='" + id + '\'' +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", territory='" + territory + '\'' +
                '}';
    }
}
