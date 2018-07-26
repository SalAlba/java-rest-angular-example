package com.sal.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sal.model.Book;
import com.sal.service.BookService;

@Path("/books")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

	private BookService bookService = new BookService();
	
	@GET
	public List<Book> getAllBooks(){ return bookService.getAllBooks(); }
	
	@GET
	@Path("/{bookId}")
	public Book getBook(@PathParam("bookId") long bookId){ 
		return bookService.getBook(bookId); 
	}
	
	@POST
	public Book addBook(Book book){ return bookService.addBook(book); }
	
	@PUT
	@Path("/{bookId}")
	public Book updateBook(@PathParam("bookId") long bookId, Book book){
		book.setId(bookId);
		return bookService.updateBook(book);
	}
	
	@DELETE
	@Path("/{bookId}")
	public void removeProfile(@PathParam("bookId") long bookId){ 
		bookService.removeBook(bookId);
	}

}