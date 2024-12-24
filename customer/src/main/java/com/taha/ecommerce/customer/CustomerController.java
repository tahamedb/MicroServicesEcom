package com.taha.ecommerce.customer;

import java.util.List;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class CustomerController {

  private final CustomerService service;

  // Query to fetch all customers
  @GraphQLQuery(name = "findAllCustomers")
  public List<CustomerResponse> findAllCustomers() {
    return this.service.findAllCustomers();
  }

  // Query to fetch a customer by ID
  @GraphQLQuery(name = "findCustomerById")
  public CustomerResponse findCustomerById(@GraphQLArgument(name = "customerId") String customerId) {
    return this.service.findById(customerId);
  }

  // Query to check if a customer exists
  @GraphQLQuery(name = "customerExistsById")
  public boolean customerExistsById(@GraphQLArgument(name = "customerId") String customerId) {
    return this.service.existsById(customerId);
  }

  // Mutation to create a new customer
  @GraphQLMutation(name = "createCustomer")
  public String createCustomer(@GraphQLArgument(name = "request") @Valid CustomerRequest request) {
    return this.service.createCustomer(request);
  }

  // Mutation to update an existing customer
  @GraphQLMutation(name = "updateCustomer")
  public boolean updateCustomer(@GraphQLArgument(name = "request") @Valid CustomerRequest request) {
    this.service.updateCustomer(request);
    return true;
  }

  // Mutation to delete a customer
  @GraphQLMutation(name = "deleteCustomer")
  public boolean deleteCustomer(@GraphQLArgument(name = "customerId") String customerId) {
    this.service.deleteCustomer(customerId);
    return true;
  }

}