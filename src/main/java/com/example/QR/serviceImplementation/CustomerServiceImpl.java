package com.example.QR.serviceImplementation;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.QR.entity.Customer;
import com.example.QR.repository.CustomerRepo;
import com.example.QR.service.CustomerService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	public List<Customer> getallCustomers() {
		// TODO Auto-generated method stub
		return customerRepo.findAll();
	}

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepo.save(customer);
	}

	@Override
	public boolean deleteCustomer(long customerId) {
		Optional<Customer> customer= customerRepo.findById(customerId);
		
		if(!customer.isPresent()) {
			return false;
		}
		customerRepo.deleteById(customerId);
		return true ;
	}

	

	@Override
	public Customer updateCustomer(long customerId, Customer updateCustomer) {
		Optional<Customer> customer=customerRepo.findById(customerId);
		
		if(!customer.isPresent()) {
			throw new  EntityNotFoundException("Customer not found");
		}
		customer.get().setEmail(updateCustomer.getEmail());
		customer.get().setName(updateCustomer.getName());
		customer.get().setPhoneNumber(updateCustomer.getPhoneNumber());
		return customerRepo.save(customer.get());
	}
	
	

}
