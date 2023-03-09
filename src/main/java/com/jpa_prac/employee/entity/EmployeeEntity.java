package com.jpa_prac.employee.entity;

import com.jpa_prac.customer.entity.CustomerEntity;
import com.jpa_prac.office.entity.OfficeEntity;
import lombok.Getter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
@Table(name = "employees")
@Getter
public class EmployeeEntity {
    @Id
    @Column(name = "employeeNumber")
    private Long id;
    private String lastName;
    private String firstName;
    private String extension;
    private String email;
    private String jobTitle;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "reportsTo")
    private EmployeeEntity supervisor;
    @OneToMany(fetch = LAZY, mappedBy = "supervisor")
    private List<EmployeeEntity> reporters = new ArrayList<>();
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "officeCode")
    private OfficeEntity office;
    @OneToMany(fetch = LAZY, mappedBy = "employee")
    private List<CustomerEntity> customers = new ArrayList<>();

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "employeeNumber=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", extension='" + extension + '\'' +
                ", email='" + email + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                '}';
    }
}
