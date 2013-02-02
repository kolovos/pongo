package com.googlecode.pongo.tests.model;

import com.mongodb.DBObject;
import com.mongodb.BasicDBObject;
import java.util.List;
import org.googlecode.pongo.runtime.Pongo;
import org.googlecode.pongo.runtime.PongoList;

public class Comment extends Pongo {
	
	protected List<Comment> replies = null;
	
	public Comment() { 
		super();
		dbObject.put("replies", new BasicDBObject());
	}
	
	public Comment(DBObject dbObject) {
		super(dbObject);
	}
	
	public String getAuthor() {
		return parseString(dbObject.get("author")+"", "");
	}
	
	public Comment setAuthor(String author) {
		dbObject.put("author", author + "");
		return this;
	}
	
	public List<Comment> getReplies() {
		if (replies == null) {
			replies = new PongoList<Comment>(this, "replies");
		}
		return replies;
	}
}