package com.googlecode.pongo.tests.propogen.model;

import com.mongodb.DBObject;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBList;

import java.util.List;
import com.googlecode.pongo.runtime.Pongo;
import com.googlecode.pongo.runtime.PongoList;
import com.googlecode.pongo.runtime.PrimitiveList;
import com.googlecode.pongo.runtime.PongoFactory;

public class Partner extends Pongo {
	
	
	public Partner() { 
		super();
	}
	
	public Partner(DBObject dbObject) {
		super(dbObject);
	}
	
	public String getId() {
		return parseString(dbObject.get("id")+"", "");
	}
	
	public Partner setId(String id) {
		dbObject.put("id", id + "");
		return this;
	}
	public String getName() {
		return parseString(dbObject.get("name")+"", "");
	}
	
	public Partner setName(String name) {
		dbObject.put("name", name + "");
		return this;
	}
	public String getCountry() {
		return parseString(dbObject.get("country")+"", "");
	}
	
	public Partner setCountry(String country) {
		dbObject.put("country", country + "");
		return this;
	}
	
	
	
	
}