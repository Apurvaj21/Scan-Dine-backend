package com.example.QR.service;

import java.util.List;

import com.example.QR.entity.ItemCategory;

public interface ItemCategoryService {

	List<ItemCategory> getAllCategories();

	ItemCategory addCategory(ItemCategory itemCategory);

	boolean deleteCategory(long category_Id);

	ItemCategory updateCategory(long category_Id, ItemCategory updateCategory);

}
