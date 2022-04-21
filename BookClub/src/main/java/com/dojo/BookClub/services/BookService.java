package com.dojo.BookClub.services;


import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojo.BookClub.models.Book;
import com.dojo.BookClub.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository)
	{
		this.bookRepository=bookRepository;
	}
	
	public void Create(Book book)
	{
		bookRepository.save(book);
	}
	
	public Book ReadOne(Long id)
	{
		Optional<Book> book=bookRepository.findById(id);
		return book.isPresent()?book.get():null;
	}
	
	public ArrayList<Book> ReadAll()
	{
		ArrayList<Book> books=(ArrayList<Book>)bookRepository.findAll();
		return books;
	}
	
	public void Update(Book book)
	{
		Create(book);
	}
	
	public void Delete(Long id)
	{
		bookRepository.deleteById(id);
	}
}
