package com.NepTune.lib.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.NepTune.lib.entities.Book;
import com.NepTune.lib.entities.BookWrapper;
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
	
	public ResponseEntity<List<Book>>getBooksByTitle(String title)
	{
		ResponseEntity<List<Book>> result = null;
		
		try
		{
			result = new ResponseEntity<>(bookRepository.findByTitle(title), HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			result = new ResponseEntity<>(new ArrayList() , HttpStatus.BAD_REQUEST);
		}
		
		return result;
	}
	
	/*
	 * 
	 * controllers
	 * issuing service
	 * development pipeline
	 * 
	 * */
	
	public void addBookInLibrary(Book book)
	{
		try
		{
			bookRepository.save(book);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void removeBookFromLibrary(int id)
	{
		try
		{
			bookRepository.deleteById(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public ResponseEntity<List<BookWrapper>> getBookWrappersByTitle(String title) {
		// TODO Auto-generated method stub
		
		ResponseEntity<List<BookWrapper>> result = null;
		
		try
		{
			List<Book>books = bookRepository.findByTitle(title);
			List<BookWrapper>bookWrappers = new ArrayList();
			
			for(Book book : books)
			{
				BookWrapper bookWrapper = new BookWrapper(book.getTitle() , book.getISBN_NUMBER());
				bookWrappers.add(bookWrapper);
			}
			
			result = new ResponseEntity<>(bookWrappers, HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			result = new ResponseEntity<>(new ArrayList() , HttpStatus.BAD_REQUEST);
		}
		
		return result;
		
	}
}
