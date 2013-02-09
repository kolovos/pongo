package com.googlecode.pongo.tests.blog;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

import com.googlecode.pongo.runtime.PongoFactory;
import com.googlecode.pongo.tests.blog.model.Post;

public class MultiValuedAttributesTests extends BlogTests {

	@Test
	public void testNoDuplicatesInMultiValuedAttribute() {
		Post post = new Post();
		post.getTags().add("tag1");
		post.getTags().add("tag2");
		post.getTags().add("tag2");
		blog.getPosts().add(post);
		blog.sync();
		
		PongoFactory.getInstance().clear();
		
		assertEquals(2, posts.iterator().next().getTags().size());
	}
	
	@Test
	public void testAddNullToMultivaluedAttributeIsIgnored() {
		
		Post post = new Post();
		post.getTags().add(null);
		posts.add(post);
		blog.sync();
		
		assertEquals(0, post.getTags().size());
		
	}
	
	@Test
	public void testRemoveFromMultiValuedAttribute() {
		
		Post post = new Post();
		post.getTags().add("tag1");
		post.getTags().add("tag2");
		posts.add(post);
		blog.sync();
		
		PongoFactory.getInstance().clear();
		
		post = posts.iterator().next();
		post.getTags().remove("tag2");
		blog.sync();
		
		PongoFactory.getInstance().clear();
		
		post = posts.iterator().next();
		assertEquals(1, post.getTags().size());
		
	}
	
}
