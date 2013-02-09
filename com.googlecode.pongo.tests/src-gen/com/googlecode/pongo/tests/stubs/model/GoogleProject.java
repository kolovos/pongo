package com.googlecode.pongo.tests.stubs.model;

import com.mongodb.DBObject;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBList;

import java.util.List;
import com.googlecode.pongo.runtime.Pongo;
import com.googlecode.pongo.runtime.PongoList;
import com.googlecode.pongo.runtime.PrimitiveList;
import com.googlecode.pongo.runtime.PongoFactory;


public class GoogleProject extends com.googlecode.pongo.tests.stubs.model.ProjectFromAnotherLibrary {
	
	protected List<com.googlecode.pongo.tests.stubs.model.DeveloperFromAnotherLibrary> developers = null;
	
	
	public GoogleProject() { 
		super();
		dbObject.put("developers", new BasicDBList());
	}
	
	/*
	public GoogleProject(DBObject dbObject) {
		super(dbObject);
	}*/
	
	public String getName() {
		return parseString(dbObject.get("name")+"", "");
	}
	
	public GoogleProject setName(String name) {
		dbObject.put("name", name + "");
		notifyChanged();
		return this;
	}
	
	
	public List<com.googlecode.pongo.tests.stubs.model.DeveloperFromAnotherLibrary> getDevelopers() {
		if (developers == null) {
			developers = new PongoList<com.googlecode.pongo.tests.stubs.model.DeveloperFromAnotherLibrary>(this, "developers", false);
		}
		return developers;
	}
	
	
}