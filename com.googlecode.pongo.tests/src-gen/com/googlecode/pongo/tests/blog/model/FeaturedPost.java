package com.googlecode.pongo.tests.blog.model;

import com.mongodb.*;
import java.util.*;
import com.googlecode.pongo.runtime.*;


public class FeaturedPost extends Post {
	
	
	
	public FeaturedPost() { 
		super();
	}
	
	public String getReason() {
		return parseString(dbObject.get("reason")+"", "");
	}
	
	public FeaturedPost setReason(String reason) {
		dbObject.put("reason", reason + "");
		notifyChanged();
		return this;
	}
	
	
	
	
}