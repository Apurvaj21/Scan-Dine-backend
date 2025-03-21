package com.example.QR.service;

import java.util.List;

import com.example.QR.entity.MenuItem;

public interface MenuItemService {
	

	MenuItem addMenuItem(MenuItem menuItem);

	List<MenuItem> getAllMenuItems();

	String deletemenuItem(long itemId);

	MenuItem updateMenuItem(long itemId, MenuItem updateMenuItem);
	
	MenuItem getMenuItemById(long itemId);

}
