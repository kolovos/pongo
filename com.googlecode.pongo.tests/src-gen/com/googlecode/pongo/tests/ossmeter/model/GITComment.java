package com.googlecode.pongo.tests.ossmeter.model;

import com.mongodb.*;
import java.util.*;
import com.googlecode.pongo.runtime.*;


public class GITComment extends Pongo {
	
	protected GITUser user = null;
	
	
	public GITComment() { 
		super();
	}
	
	public String getUrl() {
		return parseString(dbObject.get("url")+"", "");
	}
	
	public GITComment setUrl(String url) {
		dbObject.put("url", url + "");
		notifyChanged();
		return this;
	}
	public String getBody() {
		return parseString(dbObject.get("body")+"", "");
	}
	
	public GITComment setBody(String body) {
		dbObject.put("body", body + "");
		notifyChanged();
		return this;
	}
	public String getCreated_at() {
		return parseString(dbObject.get("created_at")+"", "");
	}
	
	public GITComment setCreated_at(String created_at) {
		dbObject.put("created_at", created_at + "");
		notifyChanged();
		return this;
	}
	public String getUpdated_at() {
		return parseString(dbObject.get("updated_at")+"", "");
	}
	
	public GITComment setUpdated_at(String updated_at) {
		dbObject.put("updated_at", updated_at + "");
		notifyChanged();
		return this;
	}
	
	
	
	
	public GITUser getUser() {
		if (user == null && dbObject.containsField("user")) {
			user = (GITUser) PongoFactory.getInstance().createPongo((DBObject) dbObject.get("user"));
		}
		return user;
	}
	
	public GITComment setUser(GITUser user) {
		if (this.user != user) {
			if (user == null) {
				dbObject.removeField("user");
			}
			else {
				dbObject.put("user", user.getDbObject());
			}
			this.user = user;
			notifyChanged();
		}
		return this;
	}
}