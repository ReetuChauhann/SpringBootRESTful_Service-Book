package com.reetu.services;

import java.util.List;

import com.reetu.beans.Book;

public interface MyService {
	public String addBook(Book b);
	public List<Book> getallbook();
	public List<Integer> getallids();
	public String deletebook(String name);
	public List<Book> likename(String name);
	public String update(Book b);
	public List<Book> getbookbyname(String name);
}
