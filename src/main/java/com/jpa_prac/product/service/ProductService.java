package com.jpa_prac.product.service;

import com.jpa_prac.product.entity.ProductEntity;
import com.jpa_prac.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public ProductEntity findById(String id) {
        Optional<ProductEntity> foundProductOpt = productRepository.findById(id);
        if (foundProductOpt.isPresent()) {
            return foundProductOpt.get();
        }
        return null;
    }
}
