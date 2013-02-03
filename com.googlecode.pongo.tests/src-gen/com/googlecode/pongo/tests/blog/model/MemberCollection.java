package com.googlecode.pongo.tests.blog.model;


import com.googlecode.pongo.runtime.PongoCollection;
import com.googlecode.pongo.runtime.PongoCursorIterable;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;

public class MemberCollection extends PongoCollection {
	
	public MemberCollection(DBCollection dbCollection) {
		super(dbCollection);
	}
	
	public Iterable<Member> getMembers() {
		return new PongoCursorIterable<Member>(this, dbCollection.find());
	}
	
	public Iterable<Member> findMembersById(String id) {
		return new PongoCursorIterable<Member>(this, dbCollection.find(new BasicDBObject("_id", id)));
	}
	
	public Iterable<Member> findMembersByName(String q) {
		return new PongoCursorIterable<Member>(this, dbCollection.find(new BasicDBObject("name", q + "")));
	}
	
}