package com.googlecode.pongo.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.googlecode.pongo.tests.model.Post;
import com.googlecode.pongo.tests.model.PostCollection;
import com.mongodb.DB;
import com.mongodb.Mongo;

public class PerformanceTests {

	protected Mongo mongo = null;
	
	@Before
	public void setup() throws Exception {
		
		mongo = new Mongo();
		
	}
	
	@Test
	public void test() {
		DB db = mongo.getDB("blog");
		
		PostCollection postCollection = new PostCollection(db.getCollection("blog"));
		
		for (int i=0;i<5;i++) {
			Post post = new Post();
			post.setTitle("Post " + i);
			postCollection.save(post);
		}
		
	}
	
	@After
	public void teardown() {
		mongo.dropDatabase("blog");
		
	}
	
}
