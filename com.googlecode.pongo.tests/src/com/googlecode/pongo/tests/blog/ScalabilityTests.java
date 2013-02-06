package com.googlecode.pongo.tests.blog;

import static junit.framework.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.googlecode.pongo.tests.blog.model.Comment;
import com.googlecode.pongo.tests.blog.model.Post;

public class ScalabilityTests extends BlogTests {
	
	@Override
	@Before
	public void setup() throws Exception {
		super.setup();
	}
	
	@Test
	public void testInsert100000Posts() {
		for (int i=0;i<100000;i++) {
			Post post = new Post();
			post.setTitle("Post " + i);
			post.save(postsCollection);
		}
	}
	
}
