package com.googlecode.pongo.tests.model;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.BasicDBObject;
import com.mongodb.DBRef;

import java.util.List;
import org.googlecode.pongo.runtime.Pongo;
import org.googlecode.pongo.runtime.PongoCollection;
import org.googlecode.pongo.runtime.PongoFactory;
import org.googlecode.pongo.runtime.PongoList;

public class Post extends Pongo {
	
	protected List<Comment> comments = null;
	protected Author author = null;
	
	public Post() { 
		super();
		dbObject.put("comments", new BasicDBObject());
		dbObject.put("author", new BasicDBObject());
	}
	
	public Post(DBObject dbObject) {
		super(dbObject);
	}
	
	public Post setAuthor(Author author) {
		checkReferencedPongo(author);
		if (author != null) {
			createReference("author", author);
			this.author = author;
		}
		return this;
	}
	
	/*
	protected Pongo getReferenceValue(String name) {
		DBObject refObject = (DBObject) dbObject.get(name);
		if (refObject.containsField("ref") && refObject.containsField("collection")) {
			String ref = refObject.get("ref")+"";
			String collectionName = dbObject.get("collection")+"";
			BasicDBObject queryObject = new BasicDBObject("_id", ref);
			DBCollection targetCollection = getPongoCollection().getDbCollection().getDB().getCollection(collectionName);
			DBObject target = targetCollection.findOne(queryObject);
			
			if (target != null) {
				Pongo author = (Author) PongoFactory.getInstance().createPongo(target);
				author.setPongoCollection(new PongoCollection(targetCollection));
				//return pongo;
			}
		}
	}*/
	
	public Author getAuthor() {
		if (author == null) {
			Object refObject = dbObject.get("author");
			if (refObject instanceof DBRef) {
				author = (Author) PongoFactory.getInstance().resolveReference((DBRef) refObject);
			}
		}
		return author;
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