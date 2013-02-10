package com.googlecode.pongo.tests.ossmeter.model;

import com.googlecode.pongo.runtime.*;
import com.mongodb.*;

public class Ossmeter extends PongoDB {
	
	public Ossmeter(DB db) {
		super(db);
		projects = new ProjectCollection(db.getCollection("projects"));
		pongoCollections.add(projects);
	}
	
	protected ProjectCollection projects = null;
	
	public ProjectCollection getProjects() {
		return projects;
	}
	
	
}