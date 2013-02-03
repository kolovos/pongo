package com.googlecode.pongo.tests.blog.model;

import com.mongodb.DBObject;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBList;

import java.util.List;
import com.googlecode.pongo.runtime.Pongo;
import com.googlecode.pongo.runtime.PongoList;
import com.googlecode.pongo.runtime.PrimitiveList;
import com.googlecode.pongo.runtime.PongoFactory;

public class Stats extends Pongo {
	
	
	public Stats() { 
		super();
	}
	
	public Stats(DBObject dbObject) {
		super(dbObject);
	}
	
	public int getPageloads() {
		return parseInteger(dbObject.get("pageloads")+"", 0);
	}
	
	public Stats setPageloads(int pageloads) {
		dbObject.put("pageloads", pageloads + "");
		return this;
	}
	public int getVisitors() {
		return parseInteger(dbObject.get("visitors")+"", 0);
	}
	
	public Stats setVisitors(int visitors) {
		dbObject.put("visitors", visitors + "");
		return this;
	}
	
	
	
	
}