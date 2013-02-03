package com.googlecode.pongo.runtime;

import java.util.Iterator;

import com.mongodb.BasicDBList;

public class PrimitiveList<T> extends BasicDBListWrapper<T>{

	public PrimitiveList(BasicDBList dbList) {
		super(dbList);
	}

	@Override
	public Iterator<T> iterator() {
		return new PrimitiveListIterator<>(dbList.iterator());
	}

	@Override
	protected T wrap(Object o) {
		return (T) o;
	}

	@Override
	protected Object unwrap(Object o) {
		return o;
	}

}
