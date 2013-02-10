package com.googlecode.pongo.tests.ossmeter.model;

import com.mongodb.*;
import java.util.*;
import com.googlecode.pongo.runtime.*;


public class GITUser extends Pongo {
	
	protected List<GITUser> followers = null;
	
	
	public GITUser() { 
		super();
		dbObject.put("followers", new BasicDBList());
	}
	
	public String getLogin() {
		return parseString(dbObject.get("login")+"", "");
	}
	
	public GITUser setLogin(String login) {
		dbObject.put("login", login + "");
		notifyChanged();
		return this;
	}
	public String getUrl() {
		return parseString(dbObject.get("url")+"", "");
	}
	
	public GITUser setUrl(String url) {
		dbObject.put("url", url + "");
		notifyChanged();
		return this;
	}
	
	
	public List<GITUser> getFollowers() {
		if (followers == null) {
			followers = new PongoList<GITUser>(this, "followers", true);
		}
		return followers;
	}
	
	
}