package org.googlecode.pongo.runtime;

import java.util.UUID;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class Pongo {
	
	protected DBObject dbObject;
	protected Pongo container;
	protected String containingFeature = "";
	
	public Pongo() {
		this.dbObject = new BasicDBObject();
		setId(UUID.randomUUID().toString());
		setType(this.getClass().getCanonicalName());
	}
	
	public Pongo(DBObject dbObject) {
		this.dbObject = dbObject;
	}
	
	public String getId() {
		return dbObject.get("_id") + "";
	}
	
	private void setId(String id) {
		dbObject.put("_id", id);
	}
	
	private void setType(String type) {
		dbObject.put("_type", type);
	}
	
	public Pongo getContainer() {
		return container;
	}
	
	public void setContainer(Pongo container) {
		this.container = container;
		if (container == null) {
			this.containingFeature = "";
		}
	}
	
	public String getContainingFeature() {
		return containingFeature;
	}
	
	public void setContainingFeature(String containingFeature) {
		this.containingFeature = containingFeature;
	}
	
	protected String parseString(String str, String def) {
		if (str == null) return def;
		else return str;
	}
	
	protected int parseInteger(String str, int def) {
		if (str == null) return def;
		else {
			try {
				return Integer.parseInt(str);
			}
			catch (Exception ex) {
				return def;
			}
		}
	}
	
	protected long parseLong(String str, long def) {
		if (str == null) return def;
		else {
			try {
				return Long.parseLong(str);
			}
			catch (Exception ex) {
				return def;
			}
		}
	}
	
	protected boolean parseBoolean(String str, boolean def) {
		if (str == null) return def;
		else {
			try {
				return Boolean.parseBoolean(str);
			}
			catch (Exception ex) {
				return def;
			}
		}
	}
	
}
