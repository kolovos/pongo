package com.googlecode.pongo.tests.propogen.model;

import com.googlecode.pongo.runtime.PongoCollection;
import com.googlecode.pongo.runtime.PongoCursorIterable;

import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;

public class ProjectCollection extends PongoCollection {
	
	public ProjectCollection(DBCollection dbCollection) {
		super(dbCollection);
	}
	
	public Iterable<Project> getProjects() {
		return new PongoCursorIterable<Project>(this, dbCollection.find());
	}
	
	public Iterable<Project> findProjectsById(String id) {
		return new PongoCursorIterable<Project>(this, dbCollection.find(new BasicDBObject("_id", id)));
	}
	
	
}