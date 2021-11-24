package com.fabio.Brewery.web.controller;

import com.fabio.Brewery.services.CustomerService;
import com.fabio.Brewery.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("userId")UUID userId){
        return new ResponseEntity<>(customerService.getCustomerById(userId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody CustomerDto customerDto) {
        customerService.createCustomer(customerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer/" +customerDto.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleUpdate(@PathVariable("userId")UUID userId, @RequestBody CustomerDto customerDto){
        customerService.updateCustomer(userId, customerDto);
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDeleteById(@PathVariable UUID userId){
        customerService.deleteCustomer(userId);
    }

}
