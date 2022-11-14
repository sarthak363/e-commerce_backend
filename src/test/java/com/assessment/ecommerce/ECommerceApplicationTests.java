package com.assessment.ecommerce;

import com.assessment.ecommerce.Entity.Cart;
import com.assessment.ecommerce.Entity.Customer;
import com.assessment.ecommerce.Entity.Product;
import com.assessment.ecommerce.Repository.CartRepo;
import com.assessment.ecommerce.Repository.CustomerRepo;
import com.assessment.ecommerce.Repository.ProductRepo;
import com.assessment.ecommerce.Service.CartService;
import com.assessment.ecommerce.Service.CustomerService;
import com.assessment.ecommerce.Service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ECommerceApplicationTests {

    @Autowired
    private CustomerService customerService;

    @MockBean
    private CustomerRepo customerRepo;

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepo productRepo;

    @Test
    public void saveUserTest() {
        Customer customer = new Customer("Nurul",123456L);
        when(customerRepo.save(customer)).thenReturn(customer);
        assertEquals(customer, customerService.addCustomer(customer));
        Customer customer1 = new Customer("Srthak",711101L);
        when(customerRepo.save(customer)).thenReturn(customer);
        assertEquals(customer, customerService.addCustomer(customer));
        Customer customer2 = new Customer("Rahul",711102L);
        when(customerRepo.save(customer)).thenReturn(customer);
        assertEquals(customer, customerService.addCustomer(customer));
    }
    /*@Test
    public void deleteUserTest() {
        Customer customer1 = new Customer("Srthak",711101L);
        customer1.setCustomerId(1);
        customerService.deleteCustomerById(customer1.getCustomerId());
        verify(customerRepo, times(1)).deleteByCustomerId(customer1.getCustomerId());
    }*/
    @Test
    public void saveProductTest() {
        Product product1 = new Product("Soap", 25.0, 2.0, 711101L);
        when(productRepo.save(product1)).thenReturn(product1);
        assertEquals(product1, productService.addProduct(product1));
    }
}
