package com.codingdojo.BookClub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.BookClub.models.Book;
import com.codingdojo.BookClub.models.User;
import com.codingdojo.BookClub.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookServ;
	
	@GetMapping("/books")
	public String home(HttpSession session, Model model) {
		User user = (User)session.getAttribute("user");
		
		if(user == null)
			return "redirect:/";
		else {
			model.addAttribute("user", user);
			model.addAttribute("books", bookServ.allBooks());
			return "home.jsp";
		}
	}
	
	@GetMapping("/books/new")
	public String newBook(@ModelAttribute("newBook") Book newBook, HttpSession session, Model model) {
		User user = (User)session.getAttribute("user");
		
		if(user == null)
			return "redirect:/";
		else {
			model.addAttribute("user", user);
			return "addBook.jsp";
		}
	}
	
	@PostMapping("/books/new")
	public String createBook(@Valid @ModelAttribute("newBook")Book newBook, BindingResult result, HttpSession session, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("user", (User)session.getAttribute("user"));
			return "addBook.jsp";
		}
		else {
			bookServ.createBook(newBook);
			return "redirect:/books";
		}
	}
	
	@GetMapping("/books/{id}")
	public String showBook(@PathVariable("id") Long id, HttpSession session, Model model) {
		User user = (User)session.getAttribute("user");
		
		if(user == null)
			return "redirect:/";
		else {
			model.addAttribute("user", user);
			model.addAttribute("book", bookServ.findBook(id));
			return "showBook.jsp";
		}
	}
	
	@GetMapping("/books/{id}/edit")
	public String editBook(@PathVariable("id") Long id, HttpSession session, Model model) {
		Book book = bookServ.findBook(id);
		User user = (User)session.getAttribute("user");
		
		if(user == null)
			return "redirect:/";
		else if(user.getId() != book.getUser().getId())
			return "redirect:/books";
		else {
			model.addAttribute("book", book);
			return "editBook.jsp";
		}
	}
	
	@PostMapping("/books/{id}/edit")
	public String changeBook(@Valid @ModelAttribute("book")Book book, BindingResult result, @PathVariable("id") Long id, Model model) {
		if(result.hasErrors()) {
			return "editBook.jsp";
		}
		else {
			bookServ.createBook(book);
			return "redirect:/books";
		}
	}
}
