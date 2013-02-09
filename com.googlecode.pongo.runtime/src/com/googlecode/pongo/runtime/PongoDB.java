package com.googlecode.pongo.runtime;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.DB;

public class PongoDB {
	
	protected DB db;
	protected List<PongoCollection> pongoCollections = new ArrayList<PongoCollection>();
	
	public PongoDB(DB db) {
		this.db = db;
	}
	
	public List<PongoCollection> getPongoCollections() {
		return pongoCollections;
	}
	
	public void sync() {
		for (PongoCollection c : pongoCollections) {
			c.sync();
		}
	}
}
