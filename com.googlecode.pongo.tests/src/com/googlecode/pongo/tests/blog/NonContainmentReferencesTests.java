package com.googlecode.pongo.tests.blog;

import org.junit.Test;

import com.googlecode.pongo.tests.blog.model.Author;
import com.googlecode.pongo.tests.blog.model.Post;
import static junit.framework.Assert.*;

public class NonContainmentReferencesTests extends BlogTests {
	
	@Test(expected=IllegalStateException.class)
	public void testNonReferenceable() {
		Post post = new Post();
		post.setAuthor(new Author());
	}
	
	@Test
	public void testReferenceable() {
		Post post = new Post();
		Author author = new Author();
		authorCollection.save(author);
		post.setAuthor(author);
		assertEquals(post.getAuthor(), author);
	}
	
}
