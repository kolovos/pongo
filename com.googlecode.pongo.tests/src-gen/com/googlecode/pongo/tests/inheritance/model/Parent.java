package com.googlecode.pongo.tests.inheritance.model;

import com.mongodb.*;
import java.util.*;
import com.googlecode.pongo.runtime.*;


public abstract class Parent extends Pongo {
	
	
	
	public Parent() { 
		super();
	}
	
	public String getName() {
		return parseString(dbObject.get("name")+"", "");
	}
	
	public Parent setName(String name) {
		dbObject.put("name", name + "");
		notifyChanged();
		return this;
	}
	
	
	
	
}