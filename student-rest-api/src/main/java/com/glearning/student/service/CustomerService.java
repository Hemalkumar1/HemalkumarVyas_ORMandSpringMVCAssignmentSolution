package com.glearning.student.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.glearning.student.model.customer;
import com.glearning.student.repository.customerRepository;
import com.glearning.student.model.Customer;
import com.glearning.student.repository.CustomerRepository;
import com.glearning.Student.model.Customer;
import com.glearning.Student.repository.CustomerRepository;

@Service
public class CustomerService {
private final CustomerRepository customerRepository;
	
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	public Customer addCustomer(Customer customer) {
		System.out.println("Saving the customer to the set....");
		Customer savedCustomer = this.customerRepository.save(customer);
		return savedCustomer;
	}
	
	//method to return all the customers
	public Set<Customer> fetchAllCustomers(){
		return new HashSet<>(this.customerRepository.findAll());
	}
	
	
	public Customer fetchCustomerById(long customerId) {
		return this.customerRepository
					.findById(customerId)
					.orElseThrow(() -> new IllegalArgumentException("invalid customer id passed.."));
	}
	
	public void deleteCustomerById(long customerId) {
		this.customerRepository.deleteById(customerId);
	}
	
	public Customer updateCustomer(long customerId, Customer updatedCustomer) {
		System.out.println("Passed in customer is "+ updatedCustomer);
		System.out.println("Passed customer-id is :: "+ customerId);
		Customer customerFromRepository = this.fetchCustomerById(customerId);
		customerFromRepository.setEmail(updatedCustomer.getEmail());
		customerFromRepository.setFirstName(updatedCustomer.getFirstName());
		customerFromRepository.setLastName(updatedCustomer.getLastName());
		this.customerRepository.save(customerFromRepository);
		return customerFromRepository;
	}
	
}
