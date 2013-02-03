package com.googlecode.pongo.tests.propogen.model;

import com.mongodb.DBObject;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBList;

import java.util.List;
import com.googlecode.pongo.runtime.Pongo;
import com.googlecode.pongo.runtime.PongoList;
import com.googlecode.pongo.runtime.PrimitiveList;
import com.googlecode.pongo.runtime.PongoFactory;

public class Deliverable extends Pongo {
	
	protected Partner partner = null;
	
	public Deliverable() { 
		super();
		dbObject.put("partner", new BasicDBObject());
	}
	
	public Deliverable(DBObject dbObject) {
		super(dbObject);
	}
	
	public String getTitle() {
		return parseString(dbObject.get("title")+"", "");
	}
	
	public Deliverable setTitle(String title) {
		dbObject.put("title", title + "");
		return this;
	}
	public int getDue() {
		return parseInteger(dbObject.get("due")+"", 0);
	}
	
	public Deliverable setDue(int due) {
		dbObject.put("due", due + "");
		return this;
	}
	public String getNature() {
		return parseString(dbObject.get("nature")+"", "");
	}
	
	public Deliverable setNature(String nature) {
		dbObject.put("nature", nature + "");
		return this;
	}
	public String getDissemination() {
		return parseString(dbObject.get("dissemination")+"", "");
	}
	
	public Deliverable setDissemination(String dissemination) {
		dbObject.put("dissemination", dissemination + "");
		return this;
	}
	
	
	
	public Deliverable setPartner(Partner partner) {
		if (partner != null) {
			createReference("partner", partner);
			this.partner = partner;
		}
		return this;
	}
	
	public Partner getPartner() {
		if (partner == null) {
			partner = (Partner) resolveReference("partner");
		}
		return partner;
	}
	
}