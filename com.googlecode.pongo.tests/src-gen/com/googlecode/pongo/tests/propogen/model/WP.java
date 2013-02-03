package com.googlecode.pongo.tests.propogen.model;

import com.mongodb.DBObject;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBList;

import java.util.List;
import com.googlecode.pongo.runtime.Pongo;
import com.googlecode.pongo.runtime.PongoList;
import com.googlecode.pongo.runtime.PrimitiveList;
import com.googlecode.pongo.runtime.PongoFactory;

public class WP extends Pongo {
	
	protected List<Task> tasks = null;
	protected List<Effort> effort = null;
	protected List<Deliverable> deliverables = null;
	protected Partner leader = null;
	
	public WP() { 
		super();
		dbObject.put("leader", new BasicDBObject());
		dbObject.put("tasks", new BasicDBList());
		dbObject.put("effort", new BasicDBList());
		dbObject.put("deliverables", new BasicDBList());
	}
	
	public WP(DBObject dbObject) {
		super(dbObject);
	}
	
	public String getTitle() {
		return parseString(dbObject.get("title")+"", "");
	}
	
	public WP setTitle(String title) {
		dbObject.put("title", title + "");
		return this;
	}
	public String getType() {
		return parseString(dbObject.get("type")+"", "");
	}
	
	public WP setType(String type) {
		dbObject.put("type", type + "");
		return this;
	}
	
	
	public List<Task> getTasks() {
		if (tasks == null) {
			tasks = new PongoList<Task>(this, "tasks", true);
		}
		return tasks;
	}
	public List<Effort> getEffort() {
		if (effort == null) {
			effort = new PongoList<Effort>(this, "effort", true);
		}
		return effort;
	}
	public List<Deliverable> getDeliverables() {
		if (deliverables == null) {
			deliverables = new PongoList<Deliverable>(this, "deliverables", true);
		}
		return deliverables;
	}
	
	public WP setLeader(Partner leader) {
		if (leader != null) {
			createReference("leader", leader);
			this.leader = leader;
		}
		return this;
	}
	
	public Partner getLeader() {
		if (leader == null) {
			leader = (Partner) resolveReference("leader");
		}
		return leader;
	}
	
}