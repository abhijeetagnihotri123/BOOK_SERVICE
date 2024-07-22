package com.NepTune.lib.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.NepTune.lib.entities.Book;
import com.NepTune.lib.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public ResponseEntity<List<Book>>getAllBooks()
	{
		ResponseEntity<List<Book>> result = null;
		
		try
		{
			result = new ResponseEntity<>(bookRepository.findAll() , HttpStatus.OK);
		}
		catch(Exception e)
		{	
			e.printStackTrace();
			result = new ResponseEntity<>(new ArrayList() , HttpStatus.BAD_REQUEST);
		}
		
		return result;
	}
	
}
