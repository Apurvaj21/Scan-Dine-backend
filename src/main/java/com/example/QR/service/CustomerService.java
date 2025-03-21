package com.example.QR.service;

import java.util.List;

import com.example.QR.entity.Customer;

public interface CustomerService {

	List<Customer> getallCustomers();

	Customer addCustomer(Customer customer);

	boolean deleteCustomer(long customerId);

	Customer updateCustomer(long customerId, Customer updateCustomer);

}
