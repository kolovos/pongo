package org.googlecode.pongo.runtime;

import java.util.Iterator;

import com.mongodb.BasicDBList;
import com.mongodb.DBObject;

public class PongoListIterator<T extends Pongo> implements Iterator<T>{
	
	protected BasicDBList dbList = null;
	protected Iterator<Object> dbListIterator = null; 
	
	public PongoListIterator(BasicDBList dbList) {
		this.dbList = dbList;
		dbListIterator = dbList.iterator();
	}
		
	@Override
	public boolean hasNext() {
		return dbListIterator.hasNext();
	}

	@Override
	public T next() {
		return (T) PongoFactory.getInstance().createPongo((DBObject) dbListIterator.next());
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
	
}
