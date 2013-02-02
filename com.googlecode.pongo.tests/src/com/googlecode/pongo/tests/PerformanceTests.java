package com.googlecode.pongo.tests;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.bson.BSONObject;
import org.googlecode.pongo.runtime.PongoFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.googlecode.pongo.tests.model.Author;
import com.googlecode.pongo.tests.model.AuthorCollection;
import com.googlecode.pongo.tests.model.Comment;
import com.googlecode.pongo.tests.model.FeaturedPost;
import com.googlecode.pongo.tests.model.Post;
import com.googlecode.pongo.tests.model.PostCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

public class PerformanceTests {

	protected Mongo mongo = null;
	
	@Before
	public void setup() throws Exception {
		mongo = new Mongo();
		mongo.dropDatabase("blog");
	}
	
	@Test
	public void test() {
		
		DB db = mongo.getDB("blog");
		
		PostCollection postCollection = new PostCollection(db.getCollection("blog"));
		AuthorCollection authorCollection = new AuthorCollection(db.getCollection("author"));
		
		Author author = new Author();
		author.setName("DK");
		authorCollection.save(author);
		
		Post post = new Post();
		post.setTitle("FP");
		post.setAuthor(author);
		postCollection.save(post);
		
		Post post1 = new Post();
		post1.setTitle("SP");
		postCollection.save(post1);		
		
		PongoFactory.getInstance().clear();
		
		for (Post p : postCollection.getPosts()) {
			System.err.println(p.getAuthor());
		}
		
		/*
		for (int i=0;i<10000;i++) {
			Post post = new FeaturedPost();
			post.setTitle("Post " + i);
			postCollection.save(post);
		}
		
		long now = System.currentTimeMillis();
		for (Post p : postCollection.findPostsByTitle("Post 500")) {
			System.err.println(p.getTitle());
		}
		System.err.println(System.currentTimeMillis() - now);*/
	}
	
	@After
	public void teardown() {
		
		
	}
	
}
