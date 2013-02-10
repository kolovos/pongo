package com.googlecode.pongo.tests.ossmeter.model;

import com.mongodb.*;
import java.util.*;
import com.googlecode.pongo.runtime.*;


public class BugTrackingSystem extends Tracker {
	
	protected List<Bug> bugs = null;
	
	
	public BugTrackingSystem() { 
		super();
		dbObject.put("bugs", new BasicDBList());
	}
	
	
	
	public List<Bug> getBugs() {
		if (bugs == null) {
			bugs = new PongoList<Bug>(this, "bugs", true);
		}
		return bugs;
	}
	
	
}