package com.googlecode.pongo.tests.blog;

import org.junit.After;
import org.junit.Before;

import com.googlecode.pongo.runtime.PongoFactory;
import com.googlecode.pongo.tests.blog.model.AuthorCollection;
import com.googlecode.pongo.tests.blog.model.BlogDB;
import com.googlecode.pongo.tests.blog.model.MemberCollection;
import com.googlecode.pongo.tests.blog.model.PostCollection;
import com.mongodb.DB;
import com.mongodb.Mongo;

public class BlogTests {

	protected DB db = null;
	PostCollection postsCollection = null;
	AuthorCollection authorsCollection = null;
	MemberCollection membersCollection = null;
	
	@Before
	public void setup() throws Exception {
		Mongo mongo = new Mongo();
		mongo.dropDatabase("blog");
		BlogDB blogDB = new BlogDB(mongo.getDB("blog"));

		postsCollection = blogDB.getPostsCollection();
		authorsCollection = blogDB.getAuthorsCollection();
		membersCollection = blogDB.getMembersCollection();
		
	}
		
	@After
	public void teardown() {
		PongoFactory.getInstance().clear();
	}
	
}
