package com.googlecode.pongo.tests.blog.model;

import com.googlecode.pongo.runtime.*;
import com.mongodb.*;

public class Blog extends PongoDB {
	
	public Blog(DB db) {
		super(db);
		posts = new PostCollection(db.getCollection("posts"));
		pongoCollections.add(posts);
		members = new MemberCollection(db.getCollection("members"));
		pongoCollections.add(members);
		authors = new AuthorCollection(db.getCollection("authors"));
		pongoCollections.add(authors);
	}
	
	protected PostCollection posts = null;
	protected MemberCollection members = null;
	protected AuthorCollection authors = null;
	
	public PostCollection getPosts() {
		return posts;
	}
	
	public MemberCollection getMembers() {
		return members;
	}
	
	public AuthorCollection getAuthors() {
		return authors;
	}
	
	
}