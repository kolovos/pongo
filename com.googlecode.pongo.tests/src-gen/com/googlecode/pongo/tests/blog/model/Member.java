package com.googlecode.pongo.tests.blog.model;

import com.mongodb.*;
import java.util.*;
import com.googlecode.pongo.runtime.*;
import com.googlecode.pongo.runtime.querying.*;


public class Member extends Person {
	
	
	
	public Member() { 
		super();
		super.setSuperTypes("com.googlecode.pongo.tests.blog.model.Person");
		NAME.setOwningType("com.googlecode.pongo.tests.blog.model.Member");
	}
	
	public static StringQueryProducer NAME = new StringQueryProducer("name"); 
	
	
	
	
	
	
}