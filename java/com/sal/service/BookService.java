package com.sal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sal.database.DatabaseClass;
import com.sal.model.Book;

public class BookService {

	// fields ...
	private Map<Long, Book> books = DatabaseClass.getBook();
	
	
	// constructor ...
	public BookService(){
		books.put(1l, new Book(1, "a", "Action"));
		books.put(2l, new Book(2, "b", "History"));
	}
	
	// methods ...
	public List<Book> getAllBooks(){ return new ArrayList<>(books.values()); }
	
	public Book getBook(long id){ return books.get(id); }
	
	public Book addBook(Book book){
		book.setId(books.size()+1);
		books.put(book.getId(), book);
		return book;
	}
	
	public Book updateBook(Book book){
		//if(book.getName().isEmpty()) return null;
		books.put(book.getId(), book);
		return book;
	}
	
	public Book removeBook(long id){
		return books.remove(id);
	}
	
	
}