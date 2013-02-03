package com.googlecode.pongo.tests.blog.model;

import com.googlecode.pongo.runtime.Pongo;
import com.googlecode.pongo.runtime.PongoList;
import com.googlecode.pongo.runtime.PrimitiveList;
import com.mongodb.DBObject;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBList;

import java.util.List;

public class Author extends Person {
	
	
	public Author() { 
		super();
	}
	
	public Author(DBObject dbObject) {
		super(dbObject);
	}
	
	
	
	
	
}