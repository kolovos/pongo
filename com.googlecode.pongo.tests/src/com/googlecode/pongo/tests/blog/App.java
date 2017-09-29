package com.googlecode.pongo.tests.blog;

import com.googlecode.pongo.tests.blog.model.Author;
import com.googlecode.pongo.tests.blog.model.Blog;
import com.googlecode.pongo.tests.blog.model.Comment;
import com.googlecode.pongo.tests.blog.model.Post;
import com.mongodb.Mongo;

public class App {
	
	public static void main(String[] args) throws Exception {
		new App().run();
	}
	
	public void run() throws Exception {
		
		Mongo mongo = new Mongo();
		mongo.dropDatabase("blog");
		Blog blog = new Blog(mongo.getDB("blog"));
		blog.setClearPongoCacheOnSync(true);
		
		Post post = new Post();
		post.setTitle("A post");
		
		/*
		Author author = new Author();
		author.setName("Joe Doe");
		blog.getAuthors().add(author);
		post.setAuthor(author);
		
		Comment comment = new Comment();
		comment.setText("A comment");
		post.getComments().add(comment);
		
		Comment reply = new Comment();
		reply.setText("A reply");
		comment.getReplies().add(reply);
		*/
		
		blog.getPosts().add(post);
		blog.sync();
		
		// Post p = blog.getPosts().findOneByTitle("A post");
		// System.out.println(p.getAuthor().getName());
	}
	
}
