package com.example.QR.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.QR.entity.ItemCategory;
import com.example.QR.entity.MenuItem;
import com.example.QR.repository.ItemCategoryRepo;
import com.example.QR.repository.MenuItemRepo;
import com.example.QR.service.MenuItemService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MenuItemServiceImpl implements MenuItemService {
	@Autowired
	private MenuItemRepo menuItemRepo;
	
//	 @Autowired
//	    private ItemCategoryRepo itemCategoryRepo;

	@Override
	public MenuItem addMenuItem(MenuItem menuItem) {
		return menuItemRepo.save(menuItem);
}
	
	
	
	@Override
	public List<MenuItem> getAllMenuItems() {
		return menuItemRepo.findAll();
	}

	@Override
	public String deletemenuItem(long itemId) {
		Optional<MenuItem> menuItem= menuItemRepo.findById(itemId);
		
		
		if(!menuItem.isPresent()) {
			return "menu Item not found!";
		}
		menuItemRepo.deleteById(itemId);
		return "Item deleted";
	}

	@Override
	public MenuItem updateMenuItem(long itemId, MenuItem updateMenuItem) {
		Optional<MenuItem> menuItem= menuItemRepo.findById(itemId);
		
		if(!menuItem.isPresent()) {
			throw new EntityNotFoundException("Menu Item not found");
		}
		menuItem.get().setName(updateMenuItem.getName());
		menuItem.get().setPrice(updateMenuItem.getPrice());
		menuItem.get().setImg(updateMenuItem.getImg());
		menuItem.get().setDescription(updateMenuItem.getDescription());
		
		return menuItemRepo.save(menuItem.get());
	}

	@Override
	public MenuItem getMenuItemById(long itemId) {
		// TODO Auto-generated method stub
		return menuItemRepo.findById(itemId).get();
	}
	

}
