package com.googlecode.pongo.tests.model;

import org.googlecode.pongo.runtime.PongoCollection;
import org.googlecode.pongo.runtime.PongoCursorIterator;
import org.googlecode.pongo.runtime.PongoFactory;

import com.mongodb.DBObject;
import com.mongodb.DBCollection;

public class PostCollection extends PongoCollection {
	
	public PostCollection(DBCollection dbCollection) {
		super(dbCollection);
	}
	
	public Iterable<Post> getPosts() {
		return new PongoCursorIterator<Post>(dbCollection.find()) {
			@Override
			protected Post create(DBObject dbObject) {
				return (Post) PongoFactory.getInstance().createPongo(dbObject);
			}
		};
	}
}