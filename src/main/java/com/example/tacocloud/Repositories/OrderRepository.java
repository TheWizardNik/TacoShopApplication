package com.example.tacocloud.Repositories;

import com.example.tacocloud.Entities.Order;
import com.example.tacocloud.Entities.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository
        extends CrudRepository<Order, Long> {
    List<Order> findByUserOrderByPlacedAtDesc(
            User user, Pageable pageable);

}