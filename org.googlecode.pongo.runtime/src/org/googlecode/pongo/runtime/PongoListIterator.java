package org.googlecode.pongo.runtime;

import java.util.Iterator;

import com.mongodb.DBObject;

public class PongoListIterator<T extends Pongo> implements Iterator<T>{
	
	protected DBObject dbObject = null;
	protected Iterator<String> keySetIterator = null; 
	
	public PongoListIterator(DBObject dbObject) {
		this.dbObject = dbObject;
		keySetIterator = dbObject.keySet().iterator();
	}
		
	@Override
	public boolean hasNext() {
		return keySetIterator.hasNext();
	}

	@Override
	public T next() {
		return (T) PongoFactory.getInstance().createPongo((DBObject) dbObject.get(keySetIterator.next()));
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
	
}
