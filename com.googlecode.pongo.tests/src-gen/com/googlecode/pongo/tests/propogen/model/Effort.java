package com.googlecode.pongo.tests.propogen.model;

import com.mongodb.DBObject;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBList;

import java.util.List;
import com.googlecode.pongo.runtime.Pongo;
import com.googlecode.pongo.runtime.PongoList;
import com.googlecode.pongo.runtime.PrimitiveList;
import com.googlecode.pongo.runtime.PongoFactory;

public class Effort extends Pongo {
	
	protected Partner partner = null;
	
	public Effort() { 
		super();
		dbObject.put("partner", new BasicDBObject());
	}
	
	public Effort(DBObject dbObject) {
		super(dbObject);
	}
	
	public float getMonths() {
		return parseFloat(dbObject.get("months")+"", 0.0f);
	}
	
	public Effort setMonths(float months) {
		dbObject.put("months", months + "");
		return this;
	}
	
	
	
	public Effort setPartner(Partner partner) {
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