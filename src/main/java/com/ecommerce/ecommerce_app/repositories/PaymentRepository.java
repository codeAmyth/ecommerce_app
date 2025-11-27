package com.ecommerce.ecommerce_app.repositories;

import com.ecommerce.ecommerce_app.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment , Long> {
}
