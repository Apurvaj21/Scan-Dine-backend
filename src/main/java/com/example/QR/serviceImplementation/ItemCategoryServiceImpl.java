package com.example.QR.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.QR.entity.ItemCategory;
import com.example.QR.repository.ItemCategoryRepo;
import com.example.QR.service.ItemCategoryService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ItemCategoryServiceImpl implements ItemCategoryService {
	
	@Autowired
	private ItemCategoryRepo itemCategoryRepo;

	@Override
	public List<ItemCategory> getAllCategories() {
		
		return itemCategoryRepo.findAll();
	}

	@Override
	public ItemCategory addCategory(ItemCategory itemCategory) {
		return itemCategoryRepo.save(itemCategory);
	}

	@Override
	public boolean deleteCategory(long categoryId) {
		Optional<ItemCategory> itemCategory=itemCategoryRepo.findById(categoryId);
		
		if(!itemCategory.isPresent()) {
			return false;
		}
		itemCategoryRepo.deleteById(categoryId);
		return true;
	}

	@Override
	public ItemCategory updateCategory(long categoryId, ItemCategory updateCategory) {
		Optional<ItemCategory> itemCategory=itemCategoryRepo.findById(categoryId);
		
		if(!itemCategory.isPresent()) {
			throw new EntityNotFoundException("Category not found");
		}
		itemCategory.get().setImage(updateCategory.getImage());
		itemCategory.get().setCategoryName(updateCategory.getCategoryName());
		
		
		return itemCategoryRepo.save(itemCategory.get());
	}
	
	

}
