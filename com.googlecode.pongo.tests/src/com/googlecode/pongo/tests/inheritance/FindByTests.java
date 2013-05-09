package com.googlecode.pongo.tests.inheritance;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import com.googlecode.pongo.tests.inheritance.model.ChildOne;
import com.googlecode.pongo.tests.inheritance.model.ChildTwo;
import com.googlecode.pongo.tests.inheritance.model.InheritanceDB;
import com.googlecode.pongo.tests.inheritance.model.ParentCollection;
import com.mongodb.Mongo;

public class FindByTests {

	Mongo mongo = null;
	ParentCollection classes = null;
	InheritanceDB db = null;
	
	@Before 
	public void setup() throws Exception {
		if (mongo == null) {
			mongo = new Mongo();
		}
		mongo.dropDatabase("inheritancedb");
		db = new InheritanceDB(mongo.getDB("inheritancedb"));
		db.setClearPongoCacheOnSync(true);
		
		classes = db.getClasses();
	}
	
	
	@Test
	public void testFindBy() {
		
		// Create our hierarchy
		ChildOne c11 = new ChildOne();
		c11.setName("John");
		classes.add(c11);
		
		ChildOne c12 = new ChildOne();
		c12.setName("James");
		classes.add(c12);
		
		ChildTwo c21 = new ChildTwo();
		c21.setName("John");
		classes.add(c21);
		
		db.sync();
		
		classes = db.getClasses();
	
		assertEquals(1, sizeOfIterable(classes.findChildOnesByName("John")));
		assertEquals(1, sizeOfIterable(classes.findChildOnesByName("James")));
		assertEquals(1, sizeOfIterable(classes.findChildTwosByName("John")));
		assertEquals(2, sizeOfIterable(classes.findByName("John")));
	}
	
	protected int sizeOfIterable(Iterable iterable) {
		int count = 0;
		Iterator it = iterable.iterator();
		while (it.hasNext()) {
			count++;
			it.next();
		}
		return count;
	}

}
