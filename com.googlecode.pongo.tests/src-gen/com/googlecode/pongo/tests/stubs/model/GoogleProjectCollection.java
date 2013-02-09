package com.googlecode.pongo.tests.stubs.model;

import com.googlecode.pongo.runtime.PongoCollection;
import com.googlecode.pongo.runtime.PongoCursorIterator;
import com.googlecode.pongo.runtime.IteratorIterable;

import java.util.Iterator;

import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;

public class GoogleProjectCollection extends PongoCollection<GoogleProject> {
	
	public GoogleProjectCollection(DBCollection dbCollection) {
		super(dbCollection);
	}
	
	public Iterable<GoogleProject> findById(String id) {
		return new IteratorIterable<GoogleProject>(new PongoCursorIterator<GoogleProject>(this, dbCollection.find(new BasicDBObject("_id", id))));
	}
	
	
	@Override
	public Iterator<GoogleProject> iterator() {
		return new PongoCursorIterator<GoogleProject>(this, dbCollection.find());
	}
	
	public void add(GoogleProject googleProject) {
		super.add(googleProject);
	}
	
	public void remove(GoogleProject googleProject) {
		super.remove(googleProject);
	}
	
}