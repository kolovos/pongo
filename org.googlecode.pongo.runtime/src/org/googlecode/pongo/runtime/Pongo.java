package org.googlecode.pongo.runtime;

import java.security.InvalidParameterException;
import java.util.UUID;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBRef;

public class Pongo {
	
	protected DBObject dbObject;
	protected Pongo container;
	protected String containingFeature = "";
	protected PongoCollection pongoCollection = null;
	
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
	
	public PongoCollection getPongoCollection() {
		return pongoCollection;
	}
	
	public void setPongoCollection(PongoCollection pongoCollection) {
		this.pongoCollection = pongoCollection;
	}
	
	public String getPongoPath() {
		if (container != null) {
			return container.getPongoPath() + "." + containingFeature + "." + getId();
		}
		else {
			return "";
		}
	}
	
	public void setContainingFeature(String containingFeature) {
		this.containingFeature = containingFeature;
	}
	
	protected void checkReferencedPongo(Pongo pongo) {
		if (pongo == null) return;
		if (pongo.getContainer() != null) throw new InvalidParameterException("References only work with top-level objects");
		if (pongo.getPongoCollection() == null) throw new InvalidParameterException("Reference is not associated with a collection");
	}
	
	protected void createReference(String name, Pongo to) {
		dbObject.put(name, new DBRef(to.getPongoCollection().getDbCollection().getDB(), to.getPongoCollection().getName(), to.getId()));
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
