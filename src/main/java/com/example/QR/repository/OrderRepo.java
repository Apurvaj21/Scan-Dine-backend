package com.example.QR.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.QR.entity.Customer;
import com.example.QR.entity.Orders;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Long>{
	List<Orders> findByCustomer(Customer customer);

	

}
