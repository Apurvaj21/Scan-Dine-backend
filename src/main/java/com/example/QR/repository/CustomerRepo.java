package com.example.QR.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.QR.entity.Customer;
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {


	

}
