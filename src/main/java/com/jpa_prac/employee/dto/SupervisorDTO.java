package com.jpa_prac.employee.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SupervisorDTO {
    private String employeeNumber;
    private String lastName;
    private String firstName;
    private String extension;
    private String email;
    private String jobTitle;
}
