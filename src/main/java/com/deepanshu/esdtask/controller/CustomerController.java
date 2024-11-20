package com.deepanshu.esdtask.controller;


import com.deepanshu.esdtask.dto.CustomerRequest;
import com.deepanshu.esdtask.dto.CustomerResponse;
import com.deepanshu.esdtask.dto.UpdateCustomerRequest;
import com.deepanshu.esdtask.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerRequest request) {
        return ResponseEntity.ok(customerService.createCustomer(request));
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<String> deleteCustomer(@PathVariable String email) {
        customerService.deleteCustomer(email);
        return ResponseEntity.ok("Customer with email " + email + " deleted successfully");
    }

    @PutMapping("/{email}")
    public ResponseEntity<CustomerResponse> updateCustomer(
            @PathVariable String email,
            @RequestBody @Valid UpdateCustomerRequest request) {
        CustomerResponse updatedCustomer = customerService.updateCustomer(email, request);
        return ResponseEntity.ok(updatedCustomer);
    }
}
