package com.NepTune.lib.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NepTune.lib.entities.Book;

public interface BookRepository extends JpaRepository<Book,Integer>{

	
	
}
