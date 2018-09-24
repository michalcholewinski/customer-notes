package com.customernotes.notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer){
        CustomerEntity entity = new CustomerEntity();
        entity.setFirstName(customer.getFirstName());
        entity.setLastName(customer.getLastName());
        CustomerEntity saved = customerRepository.save(entity);
        return mapToCustomer(saved);
    }

    private Customer mapToCustomer(CustomerEntity saved) {
        Customer cust = new Customer();
        cust.setId(saved.getId());
        cust.setFirstName(saved.getFirstName());
        cust.setLastName(saved.getLastName());
        return cust;
    }
}
