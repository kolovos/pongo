package org.googlecode.pongo.runtime;

import org.apache.commons.collections.map.ReferenceMap;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.DBRef;

public class PongoFactory {
	
	protected static PongoFactory instance = new PongoFactory();
	protected ReferenceMap cache = null;
	
	private PongoFactory(){
		cache = new ReferenceMap(ReferenceMap.HARD, ReferenceMap.SOFT);
	}
	
	public static PongoFactory getInstance() {
		return instance;
	}
	
	public Pongo createPongo(DBObject dbObject) {
		return createPongo(dbObject, null);
	}
	
	public void clear() {
		cache.clear();
	}
	
	public Pongo resolveReference(DBRef dbRef) {
		String fullyQualifiedId = dbRef.getDB().getName() + "." + dbRef.getRef() + "." + dbRef.getId().toString();
		Pongo pongo = (Pongo) cache.get(fullyQualifiedId);
		if (pongo == null) {
			System.err.println(dbRef);
			DBObject dbObject = dbRef.getDB().getCollection(dbRef.getRef()).findOne(dbRef);
			System.err.println("dbObject: " + dbObject);
			if (dbObject != null) {
				pongo = createPongo(dbObject, dbRef.getDB().getCollection(dbRef.getRef()));
			}
		}
		return pongo;
	}
	
	public Pongo createPongo(DBObject dbObject, DBCollection dbCollection) {
		try {
			String fullyQualifieId = getFullyQualifiedId(dbObject, dbCollection);
			Pongo pongo = (Pongo) cache.get(fullyQualifieId);
			if (fullyQualifieId == null || pongo == null) {
				String className = dbObject.get("_type") + "";
				pongo = (Pongo) Class.forName(className).newInstance();
				pongo.dbObject = dbObject;
				if (fullyQualifieId != null) {
					cache.put(fullyQualifieId, pongo);
				}
			}
			return pongo;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	protected String getFullyQualifiedId(DBObject dbObject, DBCollection dbCollection) {
		if (dbCollection == null) return null;
		return dbCollection.getDB().getName() + "." + dbCollection.getName() + "." + dbObject.get("_id");
	}
	
}
