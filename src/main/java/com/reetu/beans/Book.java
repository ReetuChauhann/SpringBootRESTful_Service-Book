package com.reetu.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("/prototype")
public class Book {
                       private int id;
                       private String name;
                       private String aname;
                       private String pname;
					public int getId() {
						return id;
					}
					public void setId(int id) {
						this.id = id;
					}
					public String getName() {
						return name;
					}
					public void setName(String name) {
						this.name = name;
					}
					public String getAname() {
						return aname;
					}
					public void setAname(String aname) {
						this.aname = aname;
					}
					public String getPname() {
						return pname;
					}
					public void setPname(String pname) {
						this.pname = pname;
					}
                       
                       
}
