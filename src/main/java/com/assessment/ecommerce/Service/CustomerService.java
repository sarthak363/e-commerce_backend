package com.assessment.ecommerce.Service;

import com.assessment.ecommerce.Entity.Customer;
import com.assessment.ecommerce.Expection.CustomerNotExistException;
import com.assessment.ecommerce.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    public Customer addCustomer(Customer customer){
        return customerRepo.save(customer);
    }

    public Customer getCustomerById(Integer cId){
        Optional<Customer> optionalCustomer=customerRepo.findById(cId);
        if(!optionalCustomer.isPresent()){
            throw new CustomerNotExistException("Customer is not exists with Id "+ cId);
        }
        return optionalCustomer.get();
    }



}
