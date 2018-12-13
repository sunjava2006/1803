package com.thzhima.base.inner;

public interface MyCollection<E> { // 泛型 

	public void add(E e);  // 添加元素到集合中
	
	public void remove(E e); // 从集合中删除指定元素
	
	public boolean contain(E e); // 判断指定参数元素，是否在集合中，在返回true,否则返回false。
	
	public int size(); // 返回集合元素的数量。集合的大小。
}

