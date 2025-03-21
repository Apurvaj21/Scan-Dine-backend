package com.example.QR.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.QR.entity.MenuItem;

public interface MenuItemRepo extends JpaRepository<MenuItem, Long> {

	

	List<MenuItem> findAll();

}
