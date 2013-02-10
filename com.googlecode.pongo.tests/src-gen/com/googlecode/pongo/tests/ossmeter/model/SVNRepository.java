package com.googlecode.pongo.tests.ossmeter.model;

import com.mongodb.*;
import java.util.*;
import com.googlecode.pongo.runtime.*;


public class SVNRepository extends VCSRepository {
	
	
	
	public SVNRepository() { 
		super();
	}
	
	public String getBrowse() {
		return parseString(dbObject.get("browse")+"", "");
	}
	
	public SVNRepository setBrowse(String browse) {
		dbObject.put("browse", browse + "");
		notifyChanged();
		return this;
	}
	
	
	
	
}