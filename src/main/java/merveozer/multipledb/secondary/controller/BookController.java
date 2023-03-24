package merveozer.multipledb.secondary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import merveozer.multipledb.secondary.model.Book;
import merveozer.multipledb.secondary.repository.BookRepository;

@RestController
public class BookController {

	@Autowired
	BookRepository bookRepository;
	
	@GetMapping("/books")
	List<Book> getBooks() {
		return this.bookRepository.findAll();
	}
	
	@PostMapping("/books")
	List<Book> addBook(@RequestBody Book book) {
		bookRepository.save(book);
		return bookRepository.findAll();	
	}
}
