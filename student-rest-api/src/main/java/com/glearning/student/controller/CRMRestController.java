package com.glearning.student.controller;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.glearning.student.model.Student;
import com.glearning.student.service.StudentService;

@RestController
@RequestMapping("/api/Customer")
public class CRMRestController {
	private final CRMService crmService;

	public CRMRestController(CRMService crmService) {
		this.crmService = crmService;
	}

	@GetMapping
	public Set<Customer> fetchAllCustomers() {
		return this.crmService.fetchAllCustomers();
	}

	@GetMapping("/{id}")
	public Customer fetchCustomerById(@PathVariable("id") long customerId) {
		return this.crmService.fetchCustomerById(customerId);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Customer saveCustomer(@RequestBody Customer customer) {
		return this.crmService.addCustomer(customer);
	}
	
	@PutMapping("/{id}" )
	public Customer updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
		return this.crmService.updateCustomer(id, customer);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCustomerById(@PathVariable("id") long customerId) {
		this.crmService.deleteCustomerById(customerId);
	}
}
