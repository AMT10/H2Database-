package com.ag.h2db.h2db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookRestController {

	@Autowired
	private BookRepo repo;
	
	@PostMapping(value="/addBook",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addBook(@RequestBody Book book){
		
		Book b=repo.save(book);
		return new ResponseEntity<>("Book Saved",HttpStatus.CREATED);
		
	}
	@GetMapping(value="/booklist",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Book>> listBook(){
		
		List<Book> b=repo.findAll();
		return new ResponseEntity<List<Book>>(b,HttpStatus.CREATED);
		
	}
}
