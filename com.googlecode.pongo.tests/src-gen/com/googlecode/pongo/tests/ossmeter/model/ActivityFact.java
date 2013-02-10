package com.googlecode.pongo.tests.ossmeter.model;

import com.mongodb.*;
import java.util.*;
import com.googlecode.pongo.runtime.*;


public class ActivityFact extends Pongo {
	
	
	
	public ActivityFact() { 
		super();
	}
	
	public int getMonth() {
		return parseInteger(dbObject.get("month")+"", 0);
	}
	
	public ActivityFact setMonth(int month) {
		dbObject.put("month", month + "");
		notifyChanged();
		return this;
	}
	public int getAddedCode() {
		return parseInteger(dbObject.get("addedCode")+"", 0);
	}
	
	public ActivityFact setAddedCode(int addedCode) {
		dbObject.put("addedCode", addedCode + "");
		notifyChanged();
		return this;
	}
	public int getRemovedCode() {
		return parseInteger(dbObject.get("removedCode")+"", 0);
	}
	
	public ActivityFact setRemovedCode(int removedCode) {
		dbObject.put("removedCode", removedCode + "");
		notifyChanged();
		return this;
	}
	public int getAddedComments() {
		return parseInteger(dbObject.get("addedComments")+"", 0);
	}
	
	public ActivityFact setAddedComments(int addedComments) {
		dbObject.put("addedComments", addedComments + "");
		notifyChanged();
		return this;
	}
	public int getRemovedComments() {
		return parseInteger(dbObject.get("removedComments")+"", 0);
	}
	
	public ActivityFact setRemovedComments(int removedComments) {
		dbObject.put("removedComments", removedComments + "");
		notifyChanged();
		return this;
	}
	public int getAddedBlanks() {
		return parseInteger(dbObject.get("addedBlanks")+"", 0);
	}
	
	public ActivityFact setAddedBlanks(int addedBlanks) {
		dbObject.put("addedBlanks", addedBlanks + "");
		notifyChanged();
		return this;
	}
	public int getRemovedBlanks() {
		return parseInteger(dbObject.get("removedBlanks")+"", 0);
	}
	
	public ActivityFact setRemovedBlanks(int removedBlanks) {
		dbObject.put("removedBlanks", removedBlanks + "");
		notifyChanged();
		return this;
	}
	public int getCommits() {
		return parseInteger(dbObject.get("commits")+"", 0);
	}
	
	public ActivityFact setCommits(int commits) {
		dbObject.put("commits", commits + "");
		notifyChanged();
		return this;
	}
	public int getContributors() {
		return parseInteger(dbObject.get("contributors")+"", 0);
	}
	
	public ActivityFact setContributors(int contributors) {
		dbObject.put("contributors", contributors + "");
		notifyChanged();
		return this;
	}
	
	
	
	
}