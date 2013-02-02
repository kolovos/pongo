package org.googlecode.pongo.runtime;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import com.mongodb.BasicDBList;
import com.mongodb.DBObject;

public class PongoList<T extends Pongo> extends ArrayList<T> {
	
	protected BasicDBList dbList;
	protected Pongo container;
	protected String containingFeature;
	protected boolean containment = false;
	
	public PongoList(Pongo container, String feature, boolean containment) {
		this.container = container;
		this.containingFeature = feature;
		this.dbList = (BasicDBList) container.dbObject.get(feature);
		this.containment = containment;
	}
	
	@Override
	public int size() {
		return dbList.size();
	}

	@Override
	public boolean isEmpty() {
		return dbList.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		if (o instanceof Pongo) {
			return dbList.contains(((Pongo)o).dbObject);
		}
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		return new PongoListIterator<T>(dbList);
	}

	@Override
	public Object[] toArray() {
		throw new UnsupportedOperationException();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean add(T e) {
		if (!contains(e)) {
			e.setContainer(container);
			e.setContainingFeature(containingFeature);
			dbList.add(e.dbObject);
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public boolean remove(Object o) {
		if (o instanceof Pongo) {
			((Pongo) o).setContainer(null);
			return dbList.remove(((Pongo) o).dbObject);
		}
		else return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		boolean result = c.size() > 0;
		for (T o : c) {
			result = result && add(o);
		}
		return result;
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		boolean result = c.size() > 0;
		for (Object o : c) {
			result = result && remove(o);
		}
		return result;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear() {
		dbList.clear();
	}
	
	@Override
	public T get(int index) {
		return (T) PongoFactory.getInstance().createPongo((DBObject) dbList.get(index));
	}

	@Override
	public T set(int index, T element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void add(int index, T element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public T remove(int index) {
		dbList.remove(index);
		return null;
	}

	@Override
	public int indexOf(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int lastIndexOf(Object o) {
		return indexOf(o);
	}

	@Override
	public ListIterator<T> listIterator() {
		throw new UnsupportedOperationException();
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException();
	}

}
