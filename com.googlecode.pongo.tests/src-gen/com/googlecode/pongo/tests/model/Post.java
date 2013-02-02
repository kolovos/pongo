package com.googlecode.pongo.tests.model;

import com.mongodb.DBObject;
import com.mongodb.BasicDBObject;
import java.util.List;
import org.googlecode.pongo.runtime.Pongo;
import org.googlecode.pongo.runtime.PongoList;

public class Post extends Pongo {
	
	protected List<Comment> comments = null;
	
	public Post() { 
		super();
		dbObject.put("comments", new BasicDBObject());
	}
	
	public Post(DBObject dbObject) {
		super(dbObject);
	}
	
	public String getTitle() {
		return parseString(dbObject.get("title")+"", "");
	}
	
	public Post setTitle(String title) {
		dbObject.put("title", title + "");
		return this;
	}
	
	public List<Comment> getComments() {
		if (comments == null) {
			comments = new PongoList<Comment>(this, "comments");
		}
		return comments;
	}
}