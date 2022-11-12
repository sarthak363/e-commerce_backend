package com.assessment.ecommerce.Repository;


import com.assessment.ecommerce.Entity.Cart;
import com.assessment.ecommerce.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepo extends JpaRepository<Cart,Integer> {
    List<Cart> findAllByCustomer(Customer customer);
    List<Cart> deleteByCustomer(Customer customer);
}
