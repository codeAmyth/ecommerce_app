package com.ecommerce.ecommerce_app.repositories;

import com.ecommerce.ecommerce_app.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
}
