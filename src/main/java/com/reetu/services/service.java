package com.reetu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reetu.beans.Book;
import com.reetu.dao.Bookdao;
import com.reetu.services.MyService;

@Service
public class service implements MyService {
	                                              @Autowired
	                                              Bookdao bd;

	@Override
	public String addBook(Book b) {
		
		return bd.addBook(b);
	}

	@Override
	public List<Book> getallbook() {
		
		return bd.getallbook();
	}

	@Override
	public List<Integer> getallids() {
		
		return bd.getallids();
	}

	@Override
	public String deletebook(String name) {
		
		return bd.deletebook(name);
	}

	@Override
	public List<Book> likename(String name) {
		
		return bd.likename(name);
	}

	@Override
	public String update(Book b) {
		
		return bd.update(b);
	}

	@Override
	public List<Book> getbookbyname(String name) {
		
		return bd.getbookbyname(name);
	}

}
