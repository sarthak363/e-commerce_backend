package com.assessment.ecommerce.Repository;

import com.assessment.ecommerce.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    @Override
    List<Customer> findAll();
}
