package com.ecommerce.ecommerce_app.repositories;

import com.ecommerce.ecommerce_app.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
