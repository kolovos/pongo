package com.googlecode.pongo.tests.blog.model;

import com.mongodb.DBObject;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBList;

import java.util.List;
import org.googlecode.pongo.runtime.Pongo;
import org.googlecode.pongo.runtime.PongoList;
import org.googlecode.pongo.runtime.PrimitiveList;

public class Member extends Person {
	
	
	public Member() { 
		super();
	}
	
	public Member(DBObject dbObject) {
		super(dbObject);
	}
	
	
	
	
	
}