package com.googlecode.pongo.tests.blog;

import static junit.framework.Assert.assertEquals;

import org.googlecode.pongo.runtime.PongoFactory;
import org.junit.Test;

import com.googlecode.pongo.tests.blog.model.Post;

public class MultiValuedAttributesTests extends BlogTests {

	@Test
	public void testNoDuplicatesInMultiValuedAttribute() {
		Post post = new Post();
		post.getTags().add("tag1");
		post.getTags().add("tag2");
		post.getTags().add("tag2");
		postCollection.save(post);
		
		PongoFactory.getInstance().clear();
		
		assertEquals(2, postCollection.getPosts().iterator().next().getTags().size());
	}
	
	@Test
	public void testAddNullToMultivaluedAttributeIsIgnored() {
		
		Post post = new Post();
		post.getTags().add(null);
		postCollection.save(post);
		
		assertEquals(0, post.getTags().size());
		
	}
	
	@Test
	public void testRemoveFromMultiValuedAttribute() {
		
		Post post = new Post();
		post.getTags().add("tag1");
		post.getTags().add("tag2");
		postCollection.save(post);
		
		PongoFactory.getInstance().clear();
		
		post = postCollection.getPosts().iterator().next();
		post.getTags().remove("tag2");
		post.save();
		
		PongoFactory.getInstance().clear();
		
		post = postCollection.getPosts().iterator().next();
		assertEquals(1, post.getTags().size());
		
	}
	
}
