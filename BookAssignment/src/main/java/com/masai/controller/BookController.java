package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Book;
import com.masai.exceptions.BookNotfoundException;
import com.masai.service.BookService;

@RestController
public class BookController {

	@Autowired
	BookService bookService;
	
	 
	 // Creating book
	
	 @PostMapping("/bookservice/books")
	 public Book createNewBook(@RequestBody Book book) {
		 
	  return this.bookService.createNewBook(book);
	  
	 }
	
	@GetMapping("/bookservice/books")
	public List<Book> getbooks() throws BookNotfoundException{
	   return this.bookService.getAllBookDetails();
	}
	
	
	
	@PutMapping(value ="bookservice/books/{id}")
	public ResponseEntity<Book> updateBookHandler(@PathVariable Integer id, @RequestBody Book book) throws BookNotfoundException{
		
	  Book updatedBook = bookService.updateBook(id, book);
		
		return new ResponseEntity<Book>(updatedBook,HttpStatus.ACCEPTED);
		
	}
	 
	 // Deleting Book By Id
	 @DeleteMapping("/bookservice/books/{id}")
	 public Book deleteBook(@PathVariable int id) throws BookNotfoundException {
		 return this.bookService.deleteBook(id);
		 
	 }
	
}
