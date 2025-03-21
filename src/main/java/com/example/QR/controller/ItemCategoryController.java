package com.example.QR.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.QR.entity.ItemCategory;
import com.example.QR.service.ItemCategoryService;

@RestController
@CrossOrigin("*")
@RequestMapping("/itemCategory")
public class ItemCategoryController {
	
	@Autowired
	private ItemCategoryService itemCategoryService;
	
	@GetMapping
	public List<ItemCategory> getAllCategories(){
		return itemCategoryService.getAllCategories();
	}
	@PostMapping
	public ItemCategory addCategory(@RequestBody ItemCategory itemCategory) {
		return itemCategoryService.addCategory(itemCategory);
	}
	
	@DeleteMapping("/categoryId/{categoryId}")
	public boolean deleteCategory(@PathVariable long categoryId) {
		return itemCategoryService.deleteCategory(categoryId);
	}
	
	@PutMapping("/categoryId/{categoryId}")
	public ItemCategory updateCategory(@PathVariable long categoryId, @RequestBody ItemCategory updateCategory) {
		return itemCategoryService.updateCategory(categoryId, updateCategory);
	}

}
