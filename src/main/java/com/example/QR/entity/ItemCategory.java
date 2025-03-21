package com.example.QR.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class ItemCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long categoryId;
	private String categoryName;
	private String image;
	
	@JsonIgnore
	@OneToMany(mappedBy = "category")
	private List <MenuItem> item;
	
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public List<MenuItem> getItem() {
		return item;
	}
	public void setItem(List<MenuItem> item) {
		this.item = item;
	}
	@Override
	public String toString() {
		return "ItemCategory [categoryId=" + categoryId + ", categoryName=" + categoryName + ", image=" + image
				+ ", item=" + item + ", getCategoryId()=" + getCategoryId() + ", getCategoryName()="
				+ getCategoryName() + ", getImage()=" + getImage() + ", getItem()=" + getItem() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
}
