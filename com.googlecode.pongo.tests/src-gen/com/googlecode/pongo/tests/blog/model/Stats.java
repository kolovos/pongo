package com.googlecode.pongo.tests.blog.model;

import com.mongodb.*;
import java.util.*;
import com.googlecode.pongo.runtime.*;
import com.googlecode.pongo.runtime.querying.*;


public class Stats extends Pongo {
	
	
	
	public Stats() { 
		super();
		PAGELOADS.setOwningType("com.googlecode.pongo.tests.blog.model.Stats");
		VISITORS.setOwningType("com.googlecode.pongo.tests.blog.model.Stats");
	}
	
	public static NumericalQueryProducer PAGELOADS = new NumericalQueryProducer("pageloads");
	public static NumericalQueryProducer VISITORS = new NumericalQueryProducer("visitors");
	
	
	public int getPageloads() {
		return parseInteger(dbObject.get("pageloads")+"", 0);
	}
	
	public Stats setPageloads(int pageloads) {
		dbObject.put("pageloads", pageloads);
		notifyChanged();
		return this;
	}
	public int getVisitors() {
		return parseInteger(dbObject.get("visitors")+"", 0);
	}
	
	public Stats setVisitors(int visitors) {
		dbObject.put("visitors", visitors);
		notifyChanged();
		return this;
	}
	
	
	
	
}