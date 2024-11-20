package com.deepanshu.esdtask.mapper;

import com.deepanshu.esdtask.dto.CustomerRequest;
import com.deepanshu.esdtask.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public Customer toCustomer(CustomerRequest request) {
        return Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(request.password())
                .build();
    }
}
