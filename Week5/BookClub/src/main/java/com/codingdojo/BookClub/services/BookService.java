package com.codingdojo.BookClub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.BookClub.models.Book;
import com.codingdojo.BookClub.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;
	
	public Book createBook(Book b) {
		return bookRepo.save(b);
	}
	
	public List<Book> allBooks(){
		return bookRepo.findAll();
	}
	
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if(optionalBook.isPresent())
			return optionalBook.get();
		else
			return null;
	}
	
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
}
