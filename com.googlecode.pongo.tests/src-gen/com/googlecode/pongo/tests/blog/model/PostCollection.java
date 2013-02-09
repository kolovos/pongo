package com.googlecode.pongo.tests.blog.model;

import com.googlecode.pongo.runtime.PongoCollection;
import com.googlecode.pongo.runtime.PongoCursorIterator;
import com.googlecode.pongo.runtime.IteratorIterable;

import java.util.Iterator;

import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;

public class PostCollection extends PongoCollection<Post> {
	
	public PostCollection(DBCollection dbCollection) {
		super(dbCollection);
		createIndex("title");
	}
	
	public Iterable<Post> findById(String id) {
		return new IteratorIterable<Post>(new PongoCursorIterator<Post>(this, dbCollection.find(new BasicDBObject("_id", id))));
	}
	
	public Iterable<Post> findByTitle(String q) {
		return new IteratorIterable<Post>(new PongoCursorIterator<Post>(this, dbCollection.find(new BasicDBObject("title", q + ""))));
	}
	
	@Override
	public Iterator<Post> iterator() {
		return new PongoCursorIterator<Post>(this, dbCollection.find());
	}
	
	public void add(Post post) {
		super.add(post);
	}
	
	public void remove(Post post) {
		super.remove(post);
	}
	
}