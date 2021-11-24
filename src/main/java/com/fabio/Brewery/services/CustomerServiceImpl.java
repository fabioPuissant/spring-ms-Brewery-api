package com.fabio.Brewery.services;

import com.fabio.Brewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID id) {
        return CustomerDto.builder().customerName("Fabio N. P.").id(id).build();
    }

    @Override
    public void deleteCustomer(UUID userId) {
        log.debug("Delete customer...");
    }

    @Override
    public void createCustomer(CustomerDto customerDto) {
        log.debug("Create customer...");
        customerDto.setId(UUID.randomUUID());
    }

    @Override
    public void updateCustomer(UUID userId, CustomerDto customerDto) {
        log.debug("Update customer...");
        customerDto.setId(userId);;
    }

}
