package com.googlecode.pongo.tests.blog.model;

import com.googlecode.pongo.runtime.Pongo;
import com.googlecode.pongo.runtime.PongoList;
import com.googlecode.pongo.runtime.PrimitiveList;
import com.mongodb.DBObject;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBList;

import java.util.List;

public class Member extends Person {
	
	
	public Member() { 
		super();
	}
	
	public Member(DBObject dbObject) {
		super(dbObject);
	}
	
	
	
	
	
}