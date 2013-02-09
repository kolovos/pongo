package com.googlecode.pongo.tests.blog.model;

import com.mongodb.DBObject;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBList;

import java.util.List;
import com.googlecode.pongo.runtime.Pongo;
import com.googlecode.pongo.runtime.PongoList;
import com.googlecode.pongo.runtime.PrimitiveList;
import com.googlecode.pongo.runtime.PongoFactory;


public class Author extends Person {
	
	
	
	public Author() { 
		super();
	}
	
	public Author(DBObject dbObject) {
		super(dbObject);
	}
	
	
	
	
	
}