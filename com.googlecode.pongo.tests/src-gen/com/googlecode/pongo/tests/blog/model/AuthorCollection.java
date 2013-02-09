package com.googlecode.pongo.tests.blog.model;

import com.googlecode.pongo.runtime.PongoCollection;
import com.googlecode.pongo.runtime.PongoCursorIterator;
import com.googlecode.pongo.runtime.IteratorIterable;

import java.util.Iterator;

import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;

public class AuthorCollection extends PongoCollection<Author> {
	
	public AuthorCollection(DBCollection dbCollection) {
		super(dbCollection);
	}
	
	public Iterable<Author> findById(String id) {
		return new IteratorIterable<Author>(new PongoCursorIterator<Author>(this, dbCollection.find(new BasicDBObject("_id", id))));
	}
	
	public Iterable<Author> findByName(String q) {
		return new IteratorIterable<Author>(new PongoCursorIterator<Author>(this, dbCollection.find(new BasicDBObject("name", q + ""))));
	}
	
	@Override
	public Iterator<Author> iterator() {
		return new PongoCursorIterator<Author>(this, dbCollection.find());
	}
	
	public void add(Author author) {
		super.add(author);
	}
	
	public void remove(Author author) {
		super.remove(author);
	}
	
}