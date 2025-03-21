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

import com.example.QR.entity.MenuItem;
import com.example.QR.service.MenuItemService;

@RestController
@RequestMapping("/menuItem")
@CrossOrigin("*")
public class MenuItemController {
	@Autowired
	private MenuItemService menuItemService;
	
	@GetMapping
	public List<MenuItem> getAllMenuItems(){
		return menuItemService.getAllMenuItems();
		
	}
	@PostMapping
	public MenuItem addMenuItem(@RequestBody MenuItem menuItem) {
		return menuItemService.addMenuItem(menuItem);
	}
	
	@DeleteMapping("/itemId/{itemId}")
	public String deleteItem(@PathVariable long itemId) {
		
		return menuItemService.deletemenuItem(itemId);
		
	}
	@PutMapping("/itemId/{itemId}")
	public MenuItem updateMenuItem(@PathVariable long itemId, @RequestBody MenuItem updateMenuItem) {
		return menuItemService.updateMenuItem(itemId, updateMenuItem);
	}
	
	

}
