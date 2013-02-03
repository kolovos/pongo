package com.googlecode.pongo.tests.blog;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

import com.googlecode.pongo.runtime.PongoFactory;
import com.googlecode.pongo.tests.blog.model.Author;
import com.googlecode.pongo.tests.blog.model.Comment;
import com.googlecode.pongo.tests.blog.model.Post;
import com.googlecode.pongo.tests.blog.model.Stats;

public class SingleValuedContainmentReferencesTests extends BlogTests {

	@Test
	public void testPersistedAndLoadedOK() {
		Post post = new Post();
		Stats stats = new Stats();
		int pageloads = 100;
		int visitors = 50;
		stats.setPageloads(pageloads);
		stats.setVisitors(visitors);
		post.setStats(stats);
		
		post.save(postCollection);
		
		PongoFactory.getInstance().clear();
		
		stats = postCollection.getPosts().iterator().next().getStats();
		assertEquals(pageloads, stats.getPageloads());
		assertEquals(visitors, stats.getVisitors());
	}
	
	@Test
	public void testUnsetNonContainmentFeature() {
		Post post = new Post();
		Author author = new Author();
		author.save(authorCollection);
		post.setAuthor(author);
		post.setAuthor(null);
		
		assertEquals(null, post.getAuthor());
	}
	
	

}
