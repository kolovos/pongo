package com.googlecode.pongo.runtime;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;

public abstract class PongoCollection<T> implements Iterable<T> {
	
	protected DBCollection dbCollection;
	protected Set<Pongo> toSave = new HashSet<Pongo>();
	protected Set<Pongo> toDelete = new HashSet<Pongo>();
	
	public DBCollection getDbCollection() {
		return dbCollection;
	}
	
	public PongoCollection(DBCollection dbCollection) {
		this.dbCollection = dbCollection;
	}
	
	public void createIndex(String field) {
		dbCollection.ensureIndex(new BasicDBObject(field, 1), new BasicDBObject("background", true));
	}
	
	public String getName() {
		return dbCollection.getName();
	}
	
	protected void add(Pongo pongo) {
		pongo.setPongoCollection(this);
		toSave.add(pongo);
	}
	
	protected void remove(Pongo pongo) {
		if (toSave.contains(pongo)) {
			toSave.remove(pongo);
		}
		toDelete.add(pongo);
	}
	
	public T first() {
		return iterator().next();
	}
	
	public T second() {
		Iterator<T> iterator = iterator();
		iterator.next();
		return iterator.next();
	}
	
	public void sync() {
		for (Pongo pongo : toSave) {
			dbCollection.save(pongo.getDbObject());
		}
		toSave.clear();
		
		for (Pongo pongo : toDelete) {
			dbCollection.remove(new BasicDBObject("_id", pongo.getId()));
		}
		toDelete.clear();
	}
	
	public Set<Pongo> getToSave() {
		return toSave;
	}
	
	public Set<Pongo> getToDelete() {
		return toDelete;
	}
	
	public long size() {
		return dbCollection.count();
	}
	
}
