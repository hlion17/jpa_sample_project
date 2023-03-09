package com.jpa_prac.order.service;

import com.jpa_prac.order.entity.OrderEntity;
import com.jpa_prac.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderEntity findById(Long id) {
        Optional<OrderEntity> foundOrderOpt = orderRepository.findById(id);
        if (foundOrderOpt.isPresent()) {
            return foundOrderOpt.get();
        }
        return null;
    }
}
