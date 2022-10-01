package com.glearning.student;

import java.util.Set;
import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.glearning.student.service.CustomerService;
import com.glearning.student.model;

@SpringBootApplication
public class CRM {
	private CustomerService customerService;
	private Set<Customer> customers;
	private static Customer customer;
	static Scanner sc = new Scanner(System.in);
	static String str = new String();
	static long rowNumber;
	
	public static void main(String[] args) {
//		SpringApplication.run(CRM.class, args);
		displayAll();
		
		str = sc.next();
		
		if (str.equals("Add") || str.equals("add") ) {
		   displayAddScreen();
		   displayAll();
		}
		
		if (str.equals("Update") || str.equals("update")) {
			System.out.println("Enter the row number to update");
			rowNumber = sc.nextInt();
			System.out.println("Enter corrected first name");
			customer.getFirstName() = sc.next();
			System.out.println("Enter corrected last name");
			customer.getLastName() = sc.next();
			System.out.println("Enter corrected Email");
			customer.getEmail() = sc.next();
			updateCustomer(rowNumber, customer);
			displayAll();
		}
		
		if (str.equals("Delete") || str.equals("delete")) {
			System.out.println("Enter the row number to delete");
			rowNumber = sc.nextInt();
			deleteCustomer(rowNumber);
			displayAll();
		}
	}
	public static void displayAll() {

		System.out.println("Customer Relationship Management");
		System.out.println("  First Name     Last Name     Email      Action");
		customers = customerService.fetchAllCustomers();
		
		While (customers.hasNext()){
			System.out.println(customers.getNext());
		}
		System.out.println("");
		System.out.println("Enter Add to add, Update to update and Delete to delete");
		
			
	}
	public static void displayAddScreen() {
		System.out.println("Enter first name");
		customer.getFirstName() = sc.next();
		System.out.println("Enter last name");
		customer.getLastName() = sc.next();
		System.out.println("Enter Email");
		customer.getEmail() = sc.next();
		addCustomer(customer);
	}
}