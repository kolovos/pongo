package com.googlecode.pongo.tests.blog.model;

import com.mongodb.DBObject;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBList;

import java.util.List;
import com.googlecode.pongo.runtime.Pongo;
import com.googlecode.pongo.runtime.PongoList;
import com.googlecode.pongo.runtime.PrimitiveList;
import com.googlecode.pongo.runtime.PongoFactory;

public class Post extends Pongo {
	
	protected List<String> tags = null;
	protected List<Comment> comments = null;
	protected Author author = null;
	protected Stats stats = null;
	
	public Post() { 
		super();
		dbObject.put("author", new BasicDBObject());
		dbObject.put("tags", new BasicDBList());
		dbObject.put("comments", new BasicDBList());
	}
	
	public Post(DBObject dbObject) {
		super(dbObject);
	}
	
	public String getTitle() {
		return parseString(dbObject.get("title")+"", "");
	}
	
	public Post setTitle(String title) {
		dbObject.put("title", title + "");
		notifyChanged();
		return this;
	}
	
	public List<String> getTags() {
		if (tags == null) {
			tags = new PrimitiveList<String>(this, (BasicDBList) dbObject.get("tags"));
		}
		return tags;
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
		}
		return stats;
	}
	
	public Post setStats(Stats stats) {
		if (stats != null) {
			dbObject.put("stats", stats.getDbObject());
			this.stats = stats;
			notifyChanged();
		}
		return this;
	}
}