package com.googlecode.pongo.tests.blog.model;

import com.mongodb.*;
import java.util.*;
import com.googlecode.pongo.runtime.*;
import com.googlecode.pongo.runtime.querying.*;

// protected region custom-imports on begin
// protected region custom-imports end

public class Post extends Pongo {
	
	protected List<String> tags = null;
	protected List<Integer> ratings = null;
	protected List<Comment> comments = null;
	protected Author author = null;
	protected Stats stats = null;
	
	// protected region custom-fields-and-methods on begin
	// protected region custom-fields-and-methods end
	
	public Post() { 
		super();
		dbObject.put("author", new BasicDBObject());
		dbObject.put("stats", new Stats().getDbObject());
		dbObject.put("tags", new BasicDBList());
		dbObject.put("ratings", new BasicDBList());
		dbObject.put("comments", new BasicDBList());
		TITLE.setOwningType("com.googlecode.pongo.tests.blog.model.Post");
		TAGS.setOwningType("com.googlecode.pongo.tests.blog.model.Post");
		RATINGS.setOwningType("com.googlecode.pongo.tests.blog.model.Post");
		TYPE.setOwningType("com.googlecode.pongo.tests.blog.model.Post");
	}
	
	public static StringQueryProducer TITLE = new StringQueryProducer("title"); 
	public static StringQueryProducer TYPE = new StringQueryProducer("type"); 
	public static ArrayQueryProducer TAGS = new ArrayQueryProducer("tags");
	public static ArrayQueryProducer RATINGS = new ArrayQueryProducer("ratings");
	
	
	public String getTitle() {
		return parseString(dbObject.get("title")+"", "");
	}
	
	public Post setTitle(String title) {
		dbObject.put("title", title);
		notifyChanged();
		return this;
	}
	public PostType getType() {
		PostType type = null;
		try {
			type = PostType.valueOf(dbObject.get("type")+"");
		}
		catch (Exception ex) {}
		return type;
	}
	
	public Post setType(PostType type) {
		dbObject.put("type", type.toString());
		notifyChanged();
		return this;
	}
	
	public List<String> getTags() {
		if (tags == null) {
			tags = new PrimitiveList<String>(this, (BasicDBList) dbObject.get("tags"));
		}
		return tags;
	}
	public List<Integer> getRatings() {
		if (ratings == null) {
			ratings = new PrimitiveList<Integer>(this, (BasicDBList) dbObject.get("ratings"));
		}
		return ratings;
	}
	
	public List<Comment> getComments() {
		if (comments == null) {
			comments = new PongoList<Comment>(this, "comments", true);
		}
		return comments;
	}
	
	public Post setAuthor(Author author) {
		if (this.author != author) {
			if (author == null) {
				dbObject.put("author", new BasicDBObject());
			}
			else {
				createReference("author", author);
			}
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
	
	public Stats getStats() {
		if (stats == null && dbObject.containsField("stats")) {
			stats = (Stats) PongoFactory.getInstance().createPongo((DBObject) dbObject.get("stats"));
			stats.setContainer(this);
		}
		return stats;
	}
	
	public Post setStats(Stats stats) {
		if (this.stats != stats) {
			if (stats == null) {
				dbObject.removeField("stats");
			}
			else {
				dbObject.put("stats", stats.getDbObject());
			}
			this.stats = stats;
			notifyChanged();
		}
		return this;
	}
}