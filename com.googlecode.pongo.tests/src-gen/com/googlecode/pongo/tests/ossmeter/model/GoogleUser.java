package com.googlecode.pongo.tests.ossmeter.model;

import com.mongodb.*;
import java.util.*;
import com.googlecode.pongo.runtime.*;


public class GoogleUser extends Pongo {
	
	
	
	public GoogleUser() { 
		super();
	}
	
	public String getEmail() {
		return parseString(dbObject.get("email")+"", "");
	}
	
	public GoogleUser setEmail(String email) {
		dbObject.put("email", email + "");
		notifyChanged();
		return this;
	}
	
	
	
	
}