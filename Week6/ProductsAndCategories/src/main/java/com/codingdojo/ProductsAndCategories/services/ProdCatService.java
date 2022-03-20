package com.codingdojo.ProductsAndCategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.ProductsAndCategories.models.Category;
import com.codingdojo.ProductsAndCategories.models.Product;
import com.codingdojo.ProductsAndCategories.repositories.CategoryRepository;
import com.codingdojo.ProductsAndCategories.repositories.ProductRepository;

@Service
public class ProdCatService {

	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private CategoryRepository categoryRepo;
	
	public Product createProduct(Product p) {
		return productRepo.save(p);
	}
	
	public Category createCategory(Category c) {
		return categoryRepo.save(c);
	}
	
	public List<Product> allProducts(){
		return productRepo.findAll();
	}
	
	public List<Category> allCategories(){
		return categoryRepo.findAll();
	}
	
	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = productRepo.findById(id);
		if(optionalProduct.isPresent())
			return optionalProduct.get();
		else
			return null;
	}
	
	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = categoryRepo.findById(id);
		if(optionalCategory.isPresent())
			return optionalCategory.get();
		else
			return null;
	}
	
	public void deleteProduct(Long id) {
		productRepo.deleteById(id);
	}
	
	public void deleteCategory(Long id) {
		categoryRepo.deleteById(id);
	}
	
	public Category addProductToCategory(Long productId, Long categoryId) {
		Category thisCategory = findCategory(categoryId);
		Product thisProduct = findProduct(productId);
		thisCategory.getProducts().add(thisProduct);
		return categoryRepo.save(thisCategory);
	}
	
	public Product addCategoryToProduct(Long productId, Long categoryId) {
		Category thisCategory = findCategory(categoryId);
		Product thisProduct = findProduct(productId);
		thisProduct.getCategories().add(thisCategory);
		return productRepo.save(thisProduct);
	}
	
	public List<Category> unusedCategories(Product product){
		return categoryRepo.findByProductsNotContains(product);
	}
	
	public List<Product> unusedProducts(Category category){
		return productRepo.findByCategoriesNotContains(category);
	}
}
