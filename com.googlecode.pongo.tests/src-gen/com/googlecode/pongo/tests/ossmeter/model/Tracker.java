package com.googlecode.pongo.tests.ossmeter.model;

import com.mongodb.*;
import java.util.*;
import com.googlecode.pongo.runtime.*;


public class Tracker extends NamedElement {
	
	
	
	public Tracker() { 
		super();
	}
	
	public String getLocation() {
		return parseString(dbObject.get("location")+"", "");
	}
	
	public Tracker setLocation(String location) {
		dbObject.put("location", location + "");
		notifyChanged();
		return this;
	}
	
	
	
	
}