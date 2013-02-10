package com.googlecode.pongo.tests.blog;

import org.junit.After;
import org.junit.Before;

import com.googlecode.pongo.runtime.PongoFactory;
import com.googlecode.pongo.tests.blog.model.AuthorCollection;
import com.googlecode.pongo.tests.blog.model.Blog;
import com.googlecode.pongo.tests.blog.model.MemberCollection;
import com.googlecode.pongo.tests.blog.model.PostCollection;
import com.mongodb.DB;
import com.mongodb.Mongo;

public class BlogTests {

	PostCollection posts = null;
	AuthorCollection authors = null;
	MemberCollection members = null;
	Blog blog = null;
	
	@Before
	public void setup() throws Exception {
		Mongo mongo = new Mongo();
		mongo.dropDatabase("blog");
		blog = new Blog(mongo.getDB("blog"));

		posts = blog.getPosts();
		authors = blog.getAuthors();
		members = blog.getMembers();
		
	}
		
	@After
	public void teardown() {
		PongoFactory.getInstance().clear();
	}
	
}
