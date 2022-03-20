package com.codingdojo.ProductsAndCategories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.ProductsAndCategories.models.Category;
import com.codingdojo.ProductsAndCategories.models.Product;
import com.codingdojo.ProductsAndCategories.services.ProdCatService;

@Controller
public class ProdCatController {

	@Autowired
	private ProdCatService prodCatService;
	
	@GetMapping("/new")
	public String newProduct(@ModelAttribute("newProduct") Product newProduct, @ModelAttribute("newCategory") Category newCategory, Model model) {
		model.addAttribute("products", prodCatService.allProducts());
		model.addAttribute("categories", prodCatService.allCategories());
		return "newProdOrCat.jsp";
	}
	
	@PostMapping("/products/new")
	public String addProduct(@ModelAttribute("newProduct") Product newProduct) {
		prodCatService.createProduct(newProduct);
		return "redirect:/new";
	}
	
	@PostMapping("/categories/new")
	public String addCategory(@ModelAttribute("newCategory") Category newCategory) {
		prodCatService.createCategory(newCategory);
		return "redirect:/new";
	}
	
	@GetMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id, @ModelAttribute("newCat") Category newCat, Model model) {
		Product product = prodCatService.findProduct(id);
		model.addAttribute("product", product);
		model.addAttribute("unusedCats", prodCatService.unusedCategories(product));
		return "showProduct.jsp";
	}
	
	@PostMapping("/products/{id}")
	public String saveProduct(@PathVariable("id") Long id, @ModelAttribute("newCat") Category newCat) {
		prodCatService.addCategoryToProduct(id, newCat.getId());
		return "redirect:/products/" + id;
	}
	
	@GetMapping("/categories/{id}")
	public String showCategory(@PathVariable("id") Long id, @ModelAttribute("newProd") Product newProd, Model model) {
		Category category = prodCatService.findCategory(id);
		model.addAttribute("category", category);
		model.addAttribute("unusedProds", prodCatService.unusedProducts(category));
		return "showCategory.jsp";
	}
	
	@PostMapping("/categories/{id}")
	public String saveCategory(@PathVariable("id") Long id, @ModelAttribute("newProd") Product newProd) {
		prodCatService.addProductToCategory(newProd.getId(), id);
		return "redirect:/categories/" + id;
	}
}
