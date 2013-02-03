package com.googlecode.pongo.tests.blog.model;

import org.googlecode.pongo.runtime.PongoCollection;
import org.googlecode.pongo.runtime.PongoCursorIterable;

import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;

public class AuthorCollection extends PongoCollection {
	
	public AuthorCollection(DBCollection dbCollection) {
		super(dbCollection);
	}
	
	public Iterable<Author> getAuthors() {
		return new PongoCursorIterable<Author>(this, dbCollection.find());
	}
	
	public Iterable<Author> findAuthorsById(String id) {
		return new PongoCursorIterable<Author>(this, dbCollection.find(new BasicDBObject("_id", id)));
	}
	
	public Iterable<Author> findAuthorsByName(String q) {
		return new PongoCursorIterable<Author>(this, dbCollection.find(new BasicDBObject("name", q + "")));
	}
	
}