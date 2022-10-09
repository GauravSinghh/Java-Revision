package com.masai.service;

import java.util.List;

import com.masai.entity.Book;
import com.masai.exceptions.BookNotfoundException;

public interface BookService {
	public Book createNewBook(Book book);
	
	public List<Book> getAllBookDetails() throws BookNotfoundException;
	
	public Book deleteBook(Integer id) throws BookNotfoundException;
	
	public Book updateBook(Integer id, Book book) throws BookNotfoundException;
	
	public Book getBookById(Integer id) throws BookNotfoundException;
}
