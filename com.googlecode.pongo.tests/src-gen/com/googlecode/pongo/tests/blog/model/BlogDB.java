package com.googlecode.pongo.tests.blog.model;

import com.googlecode.pongo.runtime.PongoDB;
import com.mongodb.DB;

public class BlogDB extends PongoDB {
	
	public BlogDB(DB db) {
		super(db);
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