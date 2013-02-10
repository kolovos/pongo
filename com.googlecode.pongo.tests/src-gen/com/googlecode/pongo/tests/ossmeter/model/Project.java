package com.googlecode.pongo.tests.ossmeter.model;

import com.mongodb.*;
import java.util.*;
import com.googlecode.pongo.runtime.*;


public class Project extends NamedElement {
	
	protected List<VCSRepository> vcsRepositories = null;
	protected SizeFact sizeFact = null;
	protected ActivityFact activityFact = null;
	
	
	public Project() { 
		super();
		dbObject.put("vcsRepositories", new BasicDBList());
	}
	
	public String getDescription() {
		return parseString(dbObject.get("description")+"", "");
	}
	
	public Project setDescription(String description) {
		dbObject.put("description", description + "");
		notifyChanged();
		return this;
	}
	public int getYear() {
		return parseInteger(dbObject.get("year")+"", 0);
	}
	
	public Project setYear(int year) {
		dbObject.put("year", year + "");
		notifyChanged();
		return this;
	}
	public boolean getActive() {
		return parseBoolean(dbObject.get("active")+"", false);
	}
	
	public Project setActive(boolean active) {
		dbObject.put("active", active + "");
		notifyChanged();
		return this;
	}
	
	
	public List<VCSRepository> getVcsRepositories() {
		if (vcsRepositories == null) {
			vcsRepositories = new PongoList<VCSRepository>(this, "vcsRepositories", true);
		}
		return vcsRepositories;
	}
	
	
	public SizeFact getSizeFact() {
		if (sizeFact == null && dbObject.containsField("sizeFact")) {
			sizeFact = (SizeFact) PongoFactory.getInstance().createPongo((DBObject) dbObject.get("sizeFact"));
		}
		return sizeFact;
	}
	
	public Project setSizeFact(SizeFact sizeFact) {
		if (this.sizeFact != sizeFact) {
			if (sizeFact == null) {
				dbObject.removeField("sizeFact");
			}
			else {
				dbObject.put("sizeFact", sizeFact.getDbObject());
			}
			this.sizeFact = sizeFact;
			notifyChanged();
		}
		return this;
	}
	public ActivityFact getActivityFact() {
		if (activityFact == null && dbObject.containsField("activityFact")) {
			activityFact = (ActivityFact) PongoFactory.getInstance().createPongo((DBObject) dbObject.get("activityFact"));
		}
		return activityFact;
	}
	
	public Project setActivityFact(ActivityFact activityFact) {
		if (this.activityFact != activityFact) {
			if (activityFact == null) {
				dbObject.removeField("activityFact");
			}
			else {
				dbObject.put("activityFact", activityFact.getDbObject());
			}
			this.activityFact = activityFact;
			notifyChanged();
		}
		return this;
	}
}