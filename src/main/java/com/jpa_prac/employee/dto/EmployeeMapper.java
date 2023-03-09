package com.jpa_prac.employee.dto;

import com.jpa_prac.employee.entity.EmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mappings({
            @Mapping(source = "id", target = "employeeNumber"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "extension", target = "extension"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "jobTitle", target = "jobTitle"),
            @Mapping(target = "supervisor", ignore = true),
            @Mapping(target = "reporters", ignore = true)
    })
    EmployeeDTO toEmployeeDTO(EmployeeEntity entity);

    @Mappings({
            @Mapping(source = "id", target = "employeeNumber"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "extension", target = "extension"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "jobTitle", target = "jobTitle"),
            @Mapping(target = "supervisor", ignore = true),
            @Mapping(target = "reporters", ignore = true)
    })
    List<EmployeeDTO> toEmployeeDTOList(List<EmployeeEntity> entities);

    @Mappings({
            @Mapping(source = "id", target = "employeeNumber"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "extension", target = "extension"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "jobTitle", target = "jobTitle")
    })
    SupervisorDTO toSupervisorDTO(EmployeeEntity entity);

    @Mappings({
            @Mapping(source = "id", target = "employeeNumber"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "extension", target = "extension"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "jobTitle", target = "jobTitle")
    })
    ReporterDTO toReporterDTO(EmployeeEntity entity);

    @Mappings({
            @Mapping(source = "id", target = "employeeNumber"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "extension", target = "extension"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "jobTitle", target = "jobTitle")
    })
    List<ReporterDTO> toReporterDTOList(List<EmployeeEntity> entities);

}
