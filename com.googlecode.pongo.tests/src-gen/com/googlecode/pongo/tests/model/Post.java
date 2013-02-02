package com.googlecode.pongo.tests.model;

import org.googlecode.pongo.runtime.Pongo;
import com.mongodb.DBObject;

public class Post extends Pongo {
	
	public Post() { super(); }
	
	public Post(DBObject dbObject) { super(dbObject); };
	
	public String getTitle() {
		return parseString(dbObject.get("title")+"", "");
	}
	
	public Post setTitle(String title) {
		dbObject.put("title", title + "");
		return this;
	}
	
	
}