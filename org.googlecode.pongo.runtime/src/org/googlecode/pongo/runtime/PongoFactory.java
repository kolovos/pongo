package org.googlecode.pongo.runtime;

import com.mongodb.DBObject;

public class PongoFactory {
	
	protected static PongoFactory instance = new PongoFactory();
	
	private PongoFactory(){}
	
	public static PongoFactory getInstance() {
		return instance;
	}
	
	public Pongo createPongo(DBObject dbObject) {
		try {
			String className = dbObject.get("_type") + "";
			Pongo pongo = (Pongo) Class.forName(className).newInstance();
			pongo.dbObject = dbObject;
			return pongo;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
}
