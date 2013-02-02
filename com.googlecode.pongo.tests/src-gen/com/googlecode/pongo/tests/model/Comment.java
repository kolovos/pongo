package com.googlecode.pongo.tests.model;

import com.mongodb.DBObject;
import com.mongodb.BasicDBObject;
import java.util.List;
import org.googlecode.pongo.runtime.Pongo;
import org.googlecode.pongo.runtime.PongoList;

public class Comment extends Pongo {
	
	protected List<Comment> replies = null;
	protected Author author = null;
	
	public Comment() { 
		super();
		dbObject.put("author", new BasicDBObject());
		dbObject.put("replies", new BasicDBObject());
	}
	
	public Comment(DBObject dbObject) {
		super(dbObject);
	}
	
	
	public List<Comment> getReplies() {
		if (replies == null) {
			replies = new PongoList<Comment>(this, "replies");
		}
		return replies;
	}
	
	public Comment setAuthor(Author author) {
		checkReferencedPongo(author);
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