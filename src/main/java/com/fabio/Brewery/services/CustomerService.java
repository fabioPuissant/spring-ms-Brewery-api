package com.fabio.Brewery.services;

import com.fabio.Brewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID id);

    void deleteCustomer(UUID userId);

    void createCustomer(CustomerDto customerDto);

    void updateCustomer(UUID userId, CustomerDto customerDto);

}
