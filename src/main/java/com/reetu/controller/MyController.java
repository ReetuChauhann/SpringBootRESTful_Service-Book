package com.reetu.controller;


import com.reetu.beans.Book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reetu.services.MyService;

@RestController
public class MyController {
	                         @Autowired
	                         MyService service;
	                         
	                         @RequestMapping("/")
	      	               public String home() {
	      	            	   return "Here's Book!";
	      	               }
	                         
	                         @PostMapping(value = "/addbook", consumes= {"application/xml","application/json"})
	                         public String addbook(@RequestBody Book b) {
	                        	 String s = service.addBook(b);
	                        	 return s;	                        	 
	                         }
	                         
	                         @GetMapping(value = "/viewallbook", produces={"application/json", "application/xml"})
	                         public List<Book> viewallbook(){
	                        	 List<Book> b1 = service.getallbook();
	                        	 return b1;
	                         }
	                         
	                         @GetMapping(value = "/likenamebook/{name}", produces={"application/json", "application/xml"})
	                         public List<Book> likenamebook(@PathVariable("name") String name){
	                        	 List<Book> b2 = service.likename(name);
	                        	 return b2;
	                         }
	                         
	                        @GetMapping(value = "/getallids")
	                        public List<Integer> getallids(){
	                        	List<Integer> id = service.getallids();
	                        	return id;
	                        }
	                        
	                       @DeleteMapping(value = "/deletebook/{name}")
	                       public String deletebook(@PathVariable("name") String name) {
	                    	   String s1 = service.deletebook(name);
	                    	  if(s1=="success")
	                    		  return "Success";
	                    	  else 
	                    		  return "Failed";
	                       }
	                       
	                       @PutMapping(value = "/updatebook")
	                       public String updatebook(@RequestBody Book b) {
	                    	   String s2 = service.update(b);
	                    	   if(s2=="success")
		                    		  return "Success";
		                    	  else 
		                    		  return "Failed!";
	                       }
	                       
	                       @GetMapping(value = "/getbookbyname/{name}")
	                       public List<Book> getbookbyname(@PathVariable("name") String name) {
	                    	   List<Book> b1 = service.getbookbyname(name);
	                    	   return b1;
	                       }
	                       
	                       
}
