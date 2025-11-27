package com.ecommerce.ecommerce_app.repositories;

import com.ecommerce.ecommerce_app.model.OrderItem;
import com.ecommerce.ecommerce_app.payload.OrderItemDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
