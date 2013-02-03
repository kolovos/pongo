package com.googlecode.pongo.tests.blog.model;

import com.mongodb.DBObject;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBList;

import java.util.List;
import org.googlecode.pongo.runtime.Pongo;
import org.googlecode.pongo.runtime.PongoList;

public class Comment extends Pongo {
	
	protected List<Comment> replies = null;
	protected Author author = null;
	
	public Comment() { 
		super();
		dbObject.put("author", new BasicDBObject());
		dbObject.put("replies", new BasicDBList());
	}
	
	public Comment(DBObject dbObject) {
		super(dbObject);
	}
	
	public String getText() {
		return parseString(dbObject.get("text")+"", "");
	}
	
	public Comment setText(String text) {
		dbObject.put("text", text + "");
		return this;
	}
	
	
	public List<Comment> getReplies() {
		if (replies == null) {
			replies = new PongoList<Comment>(this, "replies", true);
		}
		return replies;
	}
	
	public Comment setAuthor(Author author) {
		if (author != null) {
			createReference("author", author);
			this.author = author;
		}
		return this;
	}
	
	public Author getAuthor() {
		if (author == null) {
			author = (Author) resolveReference("author");
		}
		return author;
	}
	
}