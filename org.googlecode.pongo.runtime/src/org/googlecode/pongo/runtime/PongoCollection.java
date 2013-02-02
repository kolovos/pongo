package org.googlecode.pongo.runtime;

import com.mongodb.DBCollection;

public class PongoCollection {
	
	protected DBCollection dbCollection;
	
	public PongoCollection(DBCollection dbCollection) {
		this.dbCollection = dbCollection;
	}
	
	public void save(Pongo pongo) {
		dbCollection.save(pongo.dbObject);
	}
	
}
