package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Repositary.BookDao;
import com.masai.entity.Book;
import com.masai.exceptions.BookNotfoundException;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookDao brDao;  //For Accessing JPA Repository
	

	@Override
	public Book createNewBook(Book book) {
		Book savedBook = brDao.save(book);
		   return savedBook;
	}
	
	

	@Override
	public List<Book> getAllBookDetails() throws BookNotfoundException {
		List<Book> Books = brDao.findAll();
		
		if(Books.size()>0)
			return Books;
		else 
			throw new BookNotfoundException("Books Not Found");
	
		
	}

	@Override
	public Book deleteBook(Integer id) throws BookNotfoundException {
		
		Book existingBook= brDao.findById(id).orElseThrow(() -> new BookNotfoundException("Book Doesn't Exist with Id "+id));
		
		brDao.delete(existingBook);
			
		 return existingBook;
	}

	

	@Override
	public Book updateBook(Integer id, Book book) throws BookNotfoundException {
	
		
		 Optional<Book> foundBook =  brDao.findById(id);
		 
		 if(!foundBook.isPresent())
			 throw new BookNotfoundException("Book not found to update with " + id);
		 
		 Book updateBook = foundBook.get();
		 
		 updateBook.setAuthor(book.getAuthor());
		 updateBook.setBook_ID(book.getBook_ID());
		 updateBook.setCategory(book.getCategory());
         updateBook.setName(book.getName());
         updateBook.setPages(book.getPages());
         updateBook.setPrice(book.getPrice());
         updateBook.setPublication(book.getPublication());
         
		 return brDao.save(updateBook);
	}
	

	

	@Override
	public Book getBookById(Integer id) throws BookNotfoundException{
		
	   Optional<Book> opt = brDao.findById(id);
		 
	    if(opt.isPresent()) {
	    	return opt.get();
	    }else
	    	throw new BookNotfoundException("Book Doesn't Exist With Id :" + id);
	}

}
