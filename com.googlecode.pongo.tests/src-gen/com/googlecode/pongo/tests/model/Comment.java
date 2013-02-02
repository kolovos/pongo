package com.googlecode.pongo.tests.model;

import org.googlecode.pongo.runtime.Pongo;
import com.mongodb.DBObject;

public class Comment extends Pongo {
	
	public Comment() { super(); }
	
	public Comment(DBObject dbObject) { super(dbObject); };
	
	public String getAuthor() {
		return parseString(dbObject.get("author")+"", "");
	}
	
	public Comment setAuthor(String author) {
		dbObject.put("author", author + "");
		return this;
	}
	
	
}