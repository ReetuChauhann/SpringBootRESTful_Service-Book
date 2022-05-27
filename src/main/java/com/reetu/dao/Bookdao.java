package com.reetu.dao;

import com.reetu.beans.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class Bookdao {
	                    @Autowired
	                    JdbcTemplate jdbcTemplate;
	                    
	                    //to add book
	                    public String addBook(Book b) {
	                    	try {
								     String query = "insert into info values(?,?,?,?)";
								     int x = jdbcTemplate.update(query, new Object[] {b.getId(),b.getName(), b.getAname(),b.getPname()});
								     if(x!=0)
								    	 return "success";
								     else
								    	 return "failed";
							} catch (Exception e) {
								e.printStackTrace();
								return "failed";
							}
	                  }
	                    
	                //to view all BOOk
	                public List<Book> getallbook(){
	                	class BookMapper implements RowMapper{

							@Override
							public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
								Book b = new Book();
								b.setId(rs.getInt("id"));
								b.setName(rs.getString("name"));
								b.setAname(rs.getString("aname"));
								b.setPname(rs.getString("pname"));
								return b;
							}
	                		
	                	}
	                
	                	final String query = "select * from info";
		                List<Book> b = jdbcTemplate.query(query, new BookMapper());
		                return b;
	                	
	                }
	                
	                //getbook by name
	                public List<Book> getbookbyname(String name){
	                	class BookMapper implements RowMapper{

							@Override
							public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
								Book b = new Book();
								b.setId(rs.getInt("id"));
								b.setName(rs.getString("name"));
								b.setAname(rs.getString("aname"));
								b.setPname(rs.getString("pname"));
								return b;
							}
	                		
	                	}
	                
	                	 try {
	                		 final String query = "select * from info where name=?";
		                	 List<Book> b = jdbcTemplate.query(query, new BookMapper(), new Object[] {name});
		                	 if(b!=null)
		                		 return b;
		                	 else 
		                          return null;
							
							
						} catch (Exception e) {
							e.printStackTrace();
							return null;
						}
					
	                }
	               // to view all ids only
	                public List<Integer> getallids(){
	                	class BookMapper implements RowMapper{

							@Override
							public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
								
								return rs.getInt("id");
							}
	                		
	                	}
	                final String query = "select * from info";
	                List<Integer> id = jdbcTemplate.query(query, new BookMapper());
	                return id;
	                }
	                
	               //to delete book
	               public String deletebook(String name) {
	            	   try {
	            		     String query = "delete from info where name=?";
						     int x = jdbcTemplate.update(query, new Object[] {name});
						     if(x!=0)
						    	 return "success";
						     else
						    	  return "failed";
					} catch (Exception e) {
						e.printStackTrace();
						return "failed";
					}
	            	   
	               }
	              // to view Like name Book
	              public List<Book> likename(String name){
	            	  class BookMapper implements RowMapper{

						@Override
						public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
							Book b = new Book();
							b.setId(rs.getInt("id"));
							b.setName(rs.getString("name"));
							b.setAname(rs.getString("aname"));
							b.setPname(rs.getString("pname"));
							return b;
						}
	            		  
	            	  }
	            	  
	            	try {
	            		 String query = "select * from info where name like ?";
		            	 List<Book> b = jdbcTemplate.query(query, new BookMapper(), new Object[] {"%"+name+"%"});
		            	 return b;
						
					} catch (Exception e) {
						e.printStackTrace();
						return null;
					}
	              }
	              
	             //to update
	             public String update(Book b) {
	            	try {
	            		 String query = "update info set name=?, aname=?, pname=? where id=?";
		            	 int x = jdbcTemplate.update(query, new Object[] {b.getName(),b.getAname(), b.getPname(), b.getId()});
		            	 if(x!=0)
		            		 return "success";
		            	 else
		            		  return "failed";
		            	 
						
					} catch (Exception e) {
						e.printStackTrace();
						return "failed";
					}
	             }

}
