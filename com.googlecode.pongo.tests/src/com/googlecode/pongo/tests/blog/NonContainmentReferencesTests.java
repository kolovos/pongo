package com.googlecode.pongo.tests.blog;

import org.junit.Test;

import com.googlecode.pongo.tests.blog.model.Author;
import com.googlecode.pongo.tests.blog.model.Comment;
import com.googlecode.pongo.tests.blog.model.Member;
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
		author.save(authorCollection);
		
		post.setAuthor(author);
		assertEquals(post.getAuthor(), author);
	}
	
	@Test(expected=IllegalStateException.class)
	public void testNonReferenceableInManyReference() {
		
		Comment comment = new Comment();
		Member member = new Member();
		
		comment.getLiked().add(member);
		
	}
	
	@Test
	public void testReferencealbeInManyReference() {
		Post post = new Post();
		Comment comment = new Comment();
		post.getComments().add(comment);
		
		Member member = new Member();
		member.save(memberCollection);
		comment.getLiked().add(member);
		post.save(postCollection);
		
		assertEquals(1, comment.getLiked().size());
		
	}
	
}
