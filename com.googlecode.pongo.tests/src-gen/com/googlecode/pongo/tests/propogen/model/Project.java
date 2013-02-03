package com.googlecode.pongo.tests.propogen.model;

import com.mongodb.DBObject;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBList;

import java.util.List;
import com.googlecode.pongo.runtime.Pongo;
import com.googlecode.pongo.runtime.PongoList;
import com.googlecode.pongo.runtime.PrimitiveList;
import com.googlecode.pongo.runtime.PongoFactory;

public class Project extends Pongo {
	
	protected List<WP> wps = null;
	protected List<Partner> partners = null;
	
	public Project() { 
		super();
		dbObject.put("wps", new BasicDBList());
		dbObject.put("partners", new BasicDBList());
	}
	
	public Project(DBObject dbObject) {
		super(dbObject);
	}
	
	public String getName() {
		return parseString(dbObject.get("name")+"", "");
	}
	
	public Project setName(String name) {
		dbObject.put("name", name + "");
		return this;
	}
	public int getDuration() {
		return parseInteger(dbObject.get("duration")+"", 0);
	}
	
	public Project setDuration(int duration) {
		dbObject.put("duration", duration + "");
		return this;
	}
	public String getTitle() {
		return parseString(dbObject.get("title")+"", "");
	}
	
	public Project setTitle(String title) {
		dbObject.put("title", title + "");
		return this;
	}
	
	
	public List<WP> getWps() {
		if (wps == null) {
			wps = new PongoList<WP>(this, "wps", true);
		}
		return wps;
	}
	public List<Partner> getPartners() {
		if (partners == null) {
			partners = new PongoList<Partner>(this, "partners", true);
		}
		return partners;
	}
	
	
}