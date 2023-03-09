package com.jpa_prac.employee.dto;

import com.jpa_prac.employee.dto.EmployeeDTO.EmployeeDTOBuilder;
import com.jpa_prac.employee.dto.ReporterDTO.ReporterDTOBuilder;
import com.jpa_prac.employee.dto.SupervisorDTO.SupervisorDTOBuilder;
import com.jpa_prac.employee.entity.EmployeeEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-10T01:50:24+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (ojdkbuild)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeDTO toEmployeeDTO(EmployeeEntity entity) {
        if ( entity == null ) {
            return null;
        }

        EmployeeDTOBuilder employeeDTO = EmployeeDTO.builder();

        if ( entity.getId() != null ) {
            employeeDTO.employeeNumber( String.valueOf( entity.getId() ) );
        }
        employeeDTO.lastName( entity.getLastName() );
        employeeDTO.firstName( entity.getFirstName() );
        employeeDTO.extension( entity.getExtension() );
        employeeDTO.email( entity.getEmail() );
        employeeDTO.jobTitle( entity.getJobTitle() );

        return employeeDTO.build();
    }

    @Override
    public List<EmployeeDTO> toEmployeeDTOList(List<EmployeeEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<EmployeeDTO> list = new ArrayList<EmployeeDTO>( entities.size() );
        for ( EmployeeEntity employeeEntity : entities ) {
            list.add( toEmployeeDTO( employeeEntity ) );
        }

        return list;
    }

    @Override
    public SupervisorDTO toSupervisorDTO(EmployeeEntity entity) {
        if ( entity == null ) {
            return null;
        }

        SupervisorDTOBuilder supervisorDTO = SupervisorDTO.builder();

        if ( entity.getId() != null ) {
            supervisorDTO.employeeNumber( String.valueOf( entity.getId() ) );
        }
        supervisorDTO.lastName( entity.getLastName() );
        supervisorDTO.firstName( entity.getFirstName() );
        supervisorDTO.extension( entity.getExtension() );
        supervisorDTO.email( entity.getEmail() );
        supervisorDTO.jobTitle( entity.getJobTitle() );

        return supervisorDTO.build();
    }

    @Override
    public ReporterDTO toReporterDTO(EmployeeEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ReporterDTOBuilder reporterDTO = ReporterDTO.builder();

        if ( entity.getId() != null ) {
            reporterDTO.employeeNumber( String.valueOf( entity.getId() ) );
        }
        reporterDTO.lastName( entity.getLastName() );
        reporterDTO.firstName( entity.getFirstName() );
        reporterDTO.extension( entity.getExtension() );
        reporterDTO.email( entity.getEmail() );
        reporterDTO.jobTitle( entity.getJobTitle() );

        return reporterDTO.build();
    }

    @Override
    public List<ReporterDTO> toReporterDTOList(List<EmployeeEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ReporterDTO> list = new ArrayList<ReporterDTO>( entities.size() );
        for ( EmployeeEntity employeeEntity : entities ) {
            list.add( toReporterDTO( employeeEntity ) );
        }

        return list;
    }
}
