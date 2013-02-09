package com.googlecode.pongo.tests.blog.model;

import com.mongodb.DBObject;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBList;

import java.util.List;
import com.googlecode.pongo.runtime.Pongo;
import com.googlecode.pongo.runtime.PongoList;
import com.googlecode.pongo.runtime.PrimitiveList;
import com.googlecode.pongo.runtime.PongoFactory;

public class Comment extends Pongo {
	
	protected List<Comment> replies = null;
	protected List<Member> liked = null;
	protected List<Member> disliked = null;
	protected Author author = null;
	
	public Comment() { 
		super();
		dbObject.put("author", new BasicDBObject());
		dbObject.put("replies", new BasicDBList());
		dbObject.put("liked", new BasicDBList());
		dbObject.put("disliked", new BasicDBList());
	}
	
	public Comment(DBObject dbObject) {
		super(dbObject);
	}
	
	public String getText() {
		return parseString(dbObject.get("text")+"", "");
	}
	
	public Comment setText(String text) {
		dbObject.put("text", text + "");
		notifyChanged();
		return this;
	}
	
	
	public List<Comment> getReplies() {
		if (replies == null) {
			replies = new PongoList<Comment>(this, "replies", true);
		}
		return replies;
	}
	public List<Member> getLiked() {
		if (liked == null) {
			liked = new PongoList<Member>(this, "liked", false);
		}
		return liked;
	}
	public List<Member> getDisliked() {
		if (disliked == null) {
			disliked = new PongoList<Member>(this, "disliked", false);
		}
		return disliked;
	}
	
	public Comment setAuthor(Author author) {
		if (author != null) {
			createReference("author", author);
			this.author = author;
			notifyChanged();
		}
		return this;
	}
	
	public Author getAuthor() {
		if (author == null) {
			author = (Author) resolveReference("author");
		}
		return author;
	}
	
}