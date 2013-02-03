package com.googlecode.pongo.tests.blog;

import org.junit.After;
import org.junit.Before;

import com.googlecode.pongo.runtime.PongoFactory;
import com.googlecode.pongo.tests.blog.model.AuthorCollection;
import com.googlecode.pongo.tests.blog.model.MemberCollection;
import com.googlecode.pongo.tests.blog.model.PostCollection;
import com.mongodb.DB;
import com.mongodb.Mongo;

public class BlogTests {

	protected DB db = null;
	PostCollection postCollection = null;
	AuthorCollection authorCollection = null;
	MemberCollection memberCollection = null;
	
	@Before
	public void setup() throws Exception {
		Mongo mongo = new Mongo();
		mongo.dropDatabase("blog");
		db = mongo.getDB("blog");
		postCollection = new PostCollection(db.getCollection("blog"));
		authorCollection = new AuthorCollection(db.getCollection("author"));
		memberCollection = new MemberCollection(db.getCollection("member"));
	}
		
	@After
	public void teardown() {
		PongoFactory.getInstance().clear();
	}
	
}
