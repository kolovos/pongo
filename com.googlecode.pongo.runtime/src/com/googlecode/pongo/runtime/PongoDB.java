package com.googlecode.pongo.runtime;

import com.mongodb.DB;

public class PongoDB {
	
	protected DB db;
	
	public PongoDB(DB db) {
		this.db = db;
	}
	
}
