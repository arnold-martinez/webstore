package com.packt.webstore.repository.impl;

import com.packt.webstore.domain.Address;
import com.packt.webstore.domain.Customer;
import com.packt.webstore.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

    private List<Customer> listOfCustomers = new ArrayList<>();

    public InMemoryCustomerRepository() {

        Address address = new Address();
        address.setState("Chicago");

        Customer john = new Customer();
        john.setCustomerId("C1234");
        john.setName("John Example");
        john.setBillingAddress(address);
        john.setNoOfOrdersMade(2);

        listOfCustomers.add(john);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return listOfCustomers;
    }
}
