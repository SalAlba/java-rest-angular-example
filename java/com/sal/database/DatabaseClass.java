package com.sal.database;

import java.util.HashMap;
import java.util.Map;

import com.sal.model.Book;

public class DatabaseClass {

	// fields ...
	private static Map<Long, Book> book = new HashMap<>();
	
	// constructor ...
	private DatabaseClass(){}
	
	// methods ...
	public static Map<Long, Book> getBook() { return book; }
	
}