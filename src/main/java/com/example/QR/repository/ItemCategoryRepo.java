package com.example.QR.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.QR.entity.ItemCategory;

public interface ItemCategoryRepo extends JpaRepository<ItemCategory, Long> {

}
