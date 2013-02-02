package org.googlecode.pongo.runtime;

import java.util.Iterator;

import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public abstract class PongoCursorIterator<T> implements Iterable<T> {
	
	protected DBCursor dbCursor;
	
	public PongoCursorIterator(DBCursor dbCursor) {
		this.dbCursor = dbCursor;
	}
	
	public void setDbCursor(DBCursor dbCursor) {
		this.dbCursor = dbCursor;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			@Override
			public boolean hasNext() {
				return dbCursor.hasNext();
			}

			@Override
			public T next() {
				return create(dbCursor.next());
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}

		};
	}
	
	protected abstract T create(DBObject dbObject); 
	
}
