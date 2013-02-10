package com.googlecode.pongo.tests.ossmeter.model;

import com.mongodb.*;
import java.util.*;
import com.googlecode.pongo.runtime.*;


public class GITContent extends Pongo {
	
	
	
	public GITContent() { 
		super();
	}
	
	public String getType() {
		return parseString(dbObject.get("type")+"", "");
	}
	
	public GITContent setType(String type) {
		dbObject.put("type", type + "");
		notifyChanged();
		return this;
	}
	public String getEnvoding() {
		return parseString(dbObject.get("envoding")+"", "");
	}
	
	public GITContent setEnvoding(String envoding) {
		dbObject.put("envoding", envoding + "");
		notifyChanged();
		return this;
	}
	public int getSize() {
		return parseInteger(dbObject.get("size")+"", 0);
	}
	
	public GITContent setSize(int size) {
		dbObject.put("size", size + "");
		notifyChanged();
		return this;
	}
	public String getName() {
		return parseString(dbObject.get("name")+"", "");
	}
	
	public GITContent setName(String name) {
		dbObject.put("name", name + "");
		notifyChanged();
		return this;
	}
	public String getPath() {
		return parseString(dbObject.get("path")+"", "");
	}
	
	public GITContent setPath(String path) {
		dbObject.put("path", path + "");
		notifyChanged();
		return this;
	}
	public String getSha() {
		return parseString(dbObject.get("sha")+"", "");
	}
	
	public GITContent setSha(String sha) {
		dbObject.put("sha", sha + "");
		notifyChanged();
		return this;
	}
	
	
	
	
}