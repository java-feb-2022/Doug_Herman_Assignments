package com.codingdojo.BooksAPI.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.BooksAPI.models.Book;
import com.codingdojo.BooksAPI.services.BookService;

@Controller
public class BookController {	
	private final BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping("/books/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Book book = bookService.findBook(id);
		
		model.addAttribute("title", book.getTitle());
		model.addAttribute("desc", book.getDescription());
		model.addAttribute("lang", book.getLanguage());
		model.addAttribute("pages", book.getNumberOfPages());
		
		return "show.jsp";
	}
}
