package com.springboot.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Book>> getAllBooks()
	{
	//	return this.bookService.getAllBooks();
     List<Book> bok=this.bookService.getAllBooks();
     if(bok.size()<=0)
     {
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
     }
     return ResponseEntity.of(Optional.of(bok));
     
	}
	
	
	@GetMapping("/book/{id}")
	@ResponseBody
	public ResponseEntity<Book> getSpecificBook(@PathVariable("id") int id)
	{
		//return this.bookService.getSpecificBook(id);
		Book bok=this.bookService.getSpecificBook(id);
        if(bok==null)
        {
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
      return ResponseEntity.of(Optional.of(bok));

	}
	
	@PostMapping("/AddBook")
	@ResponseBody
	public ResponseEntity<Book> AddBook(@RequestBody Book book)
	{
		//return this.bookService.AddBook(book);
		Book bkk=this.bookService.AddBook(book);
		try {
			return ResponseEntity.of(Optional.of(bkk));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

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
	public ResponseEntity<Book> UpdateBook(@RequestBody Book book,@PathVariable int id)
	{
		//return this.bookService.UpdateBook(book,id);
	try {
		return ResponseEntity.ok().body(this.bookService.UpdateBook(book,id));
	}
	catch(Exception e)
	{
		e.printStackTrace();
	 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	}
}
