package com.googlecode.pongo.tests.blog.model;

import com.mongodb.DB;

public class BlogDB {
	
	protected DB db = null;
	
	public BlogDB(DB db) {
		this.db = db;
	}
	
	protected PostCollection postsCollection = null;
	protected MemberCollection membersCollection = null;
	protected AuthorCollection authorsCollection = null;
	
	public PostCollection getPostsCollection() {
		if (postsCollection == null) {
			postsCollection = new PostCollection(db.getCollection("posts"));
		}
		return postsCollection;
	}
	
	public MemberCollection getMembersCollection() {
		if (membersCollection == null) {
			membersCollection = new MemberCollection(db.getCollection("members"));
		}
		return membersCollection;
	}
	
	public AuthorCollection getAuthorsCollection() {
		if (authorsCollection == null) {
			authorsCollection = new AuthorCollection(db.getCollection("authors"));
		}
		return authorsCollection;
	}
	
	
}