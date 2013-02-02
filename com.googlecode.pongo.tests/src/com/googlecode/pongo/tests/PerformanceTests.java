package com.googlecode.pongo.tests;

import java.util.List;
import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.googlecode.pongo.tests.model.Comment;
import com.googlecode.pongo.tests.model.FeaturedPost;
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
		
		Post post = new FeaturedPost();
		post.setTitle("Popular post");
		List<Comment> comments = post.getComments();
		
		Comment comment = new Comment();
		comment.setAuthor("Author");
		comments.add(comment);
		
		Comment reply = new Comment();
		comment.getReplies().add(reply);
		
		System.err.println(reply.getPongoPath());
		
		postCollection.save(post);
		
		for (Post p : postCollection.getPosts()) {
			System.err.println(p);
		}
	}
	
	@After
	public void teardown() {
		mongo.dropDatabase("blog");
		
	}
	
}
