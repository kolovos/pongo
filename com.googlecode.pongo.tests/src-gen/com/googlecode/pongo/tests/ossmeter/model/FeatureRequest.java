package com.googlecode.pongo.tests.ossmeter.model;

import com.mongodb.*;
import java.util.*;
import com.googlecode.pongo.runtime.*;
import com.googlecode.pongo.runtime.querying.*;


public abstract class FeatureRequest extends Tracker {
	
	
	
	public FeatureRequest() { 
		super();
		super.setSuperTypes("com.googlecode.pongo.tests.ossmeter.model.Tracker","com.googlecode.pongo.tests.ossmeter.model.NamedElement");
		NAME.setOwningType("com.googlecode.pongo.tests.ossmeter.model.FeatureRequest");
		LOCATION.setOwningType("com.googlecode.pongo.tests.ossmeter.model.FeatureRequest");
	}
	
	public static StringQueryProducer NAME = new StringQueryProducer("name"); 
	public static StringQueryProducer LOCATION = new StringQueryProducer("location"); 
	
	
	
	
	
	
}