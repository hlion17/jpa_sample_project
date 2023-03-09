package com.jpa_prac.employee.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class EmployeeSrchResDTO {
    private int count;
    private List<Employee> searchResult = new ArrayList<>();

    @Data
    @Builder
    public static class Employee {
        private String employeeNumber;
        private String lastName;
        private String firstName;
        private String extension;
        private String email;
        private String jobTitle;
    }

}
