package com.jpa_prac.employee.service;

import com.jpa_prac.employee.dto.EmployeeDTO;
import com.jpa_prac.employee.dto.EmployeeMapper;
import com.jpa_prac.employee.dto.response.EmployeeSrchResDTO;
import com.jpa_prac.employee.entity.EmployeeEntity;
import com.jpa_prac.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.*;
import static java.util.stream.Collectors.*;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    // 객체그래프 탐색 테스트 용도
    public EmployeeEntity findById(Long id) {
        Optional<EmployeeEntity> foundEmployeeOpt = employeeRepository.findById(id);
        if (foundEmployeeOpt.isPresent()) {
            return foundEmployeeOpt.get();
        }
        return null;
    }

    /**
     * @MethodName: retrieveAllEmployee
     * @MethodDescription: 모든 사용자 정보 조회
     * <pre>
     *     모든 사용자 정보를 조회하는 메서드
     * </pre>
     * @Author: hlion0626@gmail.com
     * @Date: 2023-03-10 오전 12:58
     * @return: 사용자조회결과 DTO
     */
    @Transactional(readOnly = true)
    public EmployeeSrchResDTO retrieveAllEmployee() {
        List<EmployeeEntity> allEmployeeEntityList = employeeRepository.findAll();

        if (CollectionUtils.isEmpty(allEmployeeEntityList)) {
            return EmployeeSrchResDTO.builder()
                    .count(0)
                    .searchResult(EMPTY_LIST)
                    .build();
        }

        List<EmployeeSrchResDTO.Employee> searchResult = employeeMapper.toEmployeeDTOList(allEmployeeEntityList).stream()
                .map(e -> EmployeeSrchResDTO.Employee.builder()
                        .employeeNumber(String.valueOf(e.getEmployeeNumber()))
                        .firstName(e.getFirstName())
                        .lastName(e.getLastName())
                        .extension(e.getExtension())
                        .email(e.getEmail())
                        .jobTitle(e.getJobTitle())
                        .build())
                .collect(toList());

        return EmployeeSrchResDTO.builder()
                .count(searchResult.size())
                .searchResult(searchResult)
                .build();
    }

    /**
     * @MethodName: retrieveEmployeeById
     * @MethodDescription: 특정사용자ID로 사용자정보를 조회
     * <pre>
     *     사용자 Entity PK값으로 사용자정보를 조회
     * </pre>
     * @Author: hlion0626@gmail.com
     * @Date: 2023-03-10 오전 12:59
     * @Param: 사용자 Entity Pk
     * @return: 사용자 DTO
     */
    @Transactional(readOnly = true)
    public EmployeeDTO retrieveEmployeeById(long employeeId) {
        Optional<EmployeeEntity> foundEmployeeOpt = employeeRepository.findById(employeeId);

        if (!foundEmployeeOpt.isPresent()) {
            return null;
        }

        EmployeeEntity foundEmployeeEntity = foundEmployeeOpt.get();
        EmployeeDTO employeeDTO = employeeMapper.toEmployeeDTO(foundEmployeeEntity);
        employeeDTO.setSupervisor(employeeMapper.toSupervisorDTO(foundEmployeeEntity.getSupervisor()));
        employeeDTO.setReporters(employeeMapper.toReporterDTOList(foundEmployeeEntity.getReporters()));
        return employeeDTO;
    }

}
