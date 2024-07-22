package com.NepTune.lib.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NepTune.lib.entities.Book;
import com.NepTune.lib.service.BookService;

@RestController
@RequestMapping("/LibraryBooks")
public class BookFetching {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/getBooks")
	public ResponseEntity<List<Book>>getBooks()
	{
		return bookService.getAllBooks();
	}
	
}
