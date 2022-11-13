package com.assessment.ecommerce.Repository;

import com.assessment.ecommerce.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    @Override
    List<Customer> findAll();
    @Transactional
    void deleteByCustomerId(int Id);
}
