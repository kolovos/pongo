package com.googlecode.pongo.tests.propogen.model;

import com.mongodb.DBObject;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBList;

import java.util.List;
import com.googlecode.pongo.runtime.Pongo;
import com.googlecode.pongo.runtime.PongoList;
import com.googlecode.pongo.runtime.PrimitiveList;
import com.googlecode.pongo.runtime.PongoFactory;

public class Task extends Pongo {
	
	protected List<Partner> partners = null;
	
	public Task() { 
		super();
		dbObject.put("partners", new BasicDBList());
	}
	
	public Task(DBObject dbObject) {
		super(dbObject);
	}
	
	public String getTitle() {
		return parseString(dbObject.get("title")+"", "");
	}
	
	public Task setTitle(String title) {
		dbObject.put("title", title + "");
		return this;
	}
	public int getStart() {
		return parseInteger(dbObject.get("start")+"", 0);
	}
	
	public Task setStart(int start) {
		dbObject.put("start", start + "");
		return this;
	}
	public int getEnd() {
		return parseInteger(dbObject.get("end")+"", 0);
	}
	
	public Task setEnd(int end) {
		dbObject.put("end", end + "");
		return this;
	}
	
	
	public List<Partner> getPartners() {
		if (partners == null) {
			partners = new PongoList<Partner>(this, "partners", false);
		}
		return partners;
	}
	
	
}