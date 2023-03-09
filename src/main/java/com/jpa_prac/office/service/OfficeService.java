package com.jpa_prac.office.service;

import com.jpa_prac.office.entity.OfficeEntity;
import com.jpa_prac.office.repository.OfficeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class OfficeService {
    private final OfficeRepository officeRepository;

    public OfficeEntity findById(String id) {
        Optional<OfficeEntity> foundOfficeOpt = officeRepository.findById(id);
        if (foundOfficeOpt.isPresent()) {
            return foundOfficeOpt.get();
        }
        return null;
    }
}
