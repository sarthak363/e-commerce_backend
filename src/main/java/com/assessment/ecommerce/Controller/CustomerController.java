package com.assessment.ecommerce.Controller;

import com.assessment.ecommerce.Entity.Customer;
import com.assessment.ecommerce.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public String addCustomer(@RequestBody Customer customer){
        return (customerService.addCustomer(customer)).toString();
    }

    @GetMapping("/{cId}")
    public String getCustomerById(@PathVariable Integer cId){
        return (customerService.getCustomerById(cId)).toString();
    }

}

