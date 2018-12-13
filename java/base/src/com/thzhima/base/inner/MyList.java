package com.thzhima.base.inner;

public interface MyList<E> extends MyCollection<E> {

	void insert(int idx, E e);
	
	void remove(int idx);
	
	E get(int idx);
}
