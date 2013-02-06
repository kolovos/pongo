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
		post.save(postsCollection);
		
		PongoFactory.getInstance().clear();
		
		assertEquals(2, postsCollection.getPosts().iterator().next().getTags().size());
	}
	
	@Test
	public void testAddNullToMultivaluedAttributeIsIgnored() {
		
		Post post = new Post();
		post.getTags().add(null);
		post.save(postsCollection);
		
		assertEquals(0, post.getTags().size());
		
	}
	
	@Test
	public void testRemoveFromMultiValuedAttribute() {
		
		Post post = new Post();
		post.getTags().add("tag1");
		post.getTags().add("tag2");
		post.save(postsCollection);
		
		PongoFactory.getInstance().clear();
		
		post = postsCollection.getPosts().iterator().next();
		post.getTags().remove("tag2");
		post.save();
		
		PongoFactory.getInstance().clear();
		
		post = postsCollection.getPosts().iterator().next();
		assertEquals(1, post.getTags().size());
		
	}
	
}
