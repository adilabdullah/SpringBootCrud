package com.springboot.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.model.Book;
import com.springboot.rest.service.BookService;

//@Controller
@RestController
public class BookController {

	@Autowired
	BookService bookService;
	
//	@RequestMapping(value="/books",method=RequestMethod.GET)
	@GetMapping("/books")
	@ResponseBody
	public List<Book> getAllBooks()
	{
		return this.bookService.getAllBooks();
	/*	Book bk=new Book();
		bk.setAuthor("Adil Abdullah");
		bk.setTitle("Spring Boot");
		bk.setId(5543);
		bk.setPrice(134.65);
		return bk;  */
	}
	
	
	@GetMapping("/book/{id}")
	@ResponseBody
	public Book getSpecificBook(@PathVariable("id") int id)
	{
		return this.bookService.getSpecificBook(id);

	}
	
	@PostMapping("/AddBook")
	@ResponseBody
	public Book AddBook(@RequestBody Book book)
	{
		return this.bookService.AddBook(book);

	}
	
	@DeleteMapping("/DeleteBook/{id}")
	@ResponseBody
	public String DeleteBook(@PathVariable int id)
	{
		if(this.bookService.DeleteBook(id)==1)
		{
			return "Book deleted succesfully";
		}
		else
		{
			return "Book does not found";
		}

	}
	
	
	@PutMapping("/UpdateBook/{id}")
	@ResponseBody
	public Book UpdateBook(@RequestBody Book book,@PathVariable int id)
	{
		return this.bookService.UpdateBook(book,id);
	}
}
