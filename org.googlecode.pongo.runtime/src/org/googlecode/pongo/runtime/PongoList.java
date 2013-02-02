package org.googlecode.pongo.runtime;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import com.mongodb.DBObject;

public class PongoList<T extends Pongo> extends ArrayList<T> {
	
	protected DBObject dbObject;
	protected Pongo container;
	protected String containingFeature;
	
	public PongoList(Pongo container, String containingFeature) {
		this.container = container;
		this.containingFeature = containingFeature;
		this.dbObject = (DBObject) container.dbObject.get(containingFeature);
	}
	
	@Override
	public int size() {
		return dbObject.keySet().size();
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public boolean contains(Object o) {
		if (o instanceof Pongo) {
			return dbObject.keySet().contains(((Pongo) o).getId());
		}
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		return new PongoListIterator<T>(dbObject);
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
			dbObject.put(e.getId(), e.dbObject);
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public boolean remove(Object o) {
		
		Pongo pongo = null;
		if (o instanceof Pongo) pongo = (Pongo) o;
		else return false;
		
		if (contains(o)) {
			pongo.setContainer(null);
			dbObject.removeField(pongo.getId());
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for (Object o : c) {
			if (!contains(o)) return false;
		}
		return c.size() > 0;
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
		List<String> keySet = new ArrayList<String>(dbObject.keySet());
		for (String key : keySet) {
			dbObject.removeField(key);
		}
	}
	
	protected String getIthKey(int index) {
		Set<String> keySet = dbObject.keySet();
		if (index > keySet.size() - 1) throw new ArrayIndexOutOfBoundsException();
		
		Iterator<String> keySetIterator = keySet.iterator();
		for (int i=0;i<index+1;i++) {
			if (keySetIterator.hasNext()) {
				String key = keySetIterator.next();
				if (i == index) return key;
			}
		}
		
		return null;
	}
	
	@Override
	public T get(int index) {
		return (T) PongoFactory.getInstance().createPongo((DBObject) dbObject.get(getIthKey(index)));
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
		dbObject.removeField(getIthKey(index));
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
