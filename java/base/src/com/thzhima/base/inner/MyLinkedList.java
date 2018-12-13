package com.thzhima.base.inner;

public class MyLinkedList<E> implements MyList<E> {
	private int size; // 缺省值就是0
	
	Node first; //缺省就为null
	Node last; //
	
	
	private class Node<E>{
		Node previous;
		Node next;
		E value;
		
		Node(){
			
		}
		
		Node(Node previous, Node next, E value){
			this.previous = previous;
			this.next = next;
			this.value = value;
		}
	}
	
	@Override
	public void add(E e) {
		if(this.size == 0) {
			Node newNode = new Node(null, null, e);
			this.first = this.last = newNode;
		}else {
			Node newNode = new Node();
			newNode.value = e;
			newNode.next = null;
			newNode.previous = this.last; // 新节点的前向指针，指向当前最后一个节点。
			this.last.next = newNode; // 当前最后一个节点的后向指针，指向新建的节点。
			this.last = newNode; // 移到尾指针，指向新添加的节点。
		}
		size++;
	}

	@Override
	public void remove(E e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contain(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void insert(int idx, E e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(int idx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E get(int idx) {
		if(idx<0 || idx>=size) {
			throw new IndexOutOfBoundsException("超出列表的长度范围.");
		}
		else {
			Node<E> curr = first;
			for( int i=0; i<idx ; i++) {
				curr = curr.next;
			}
			return curr.value;
		}
		
	}

	@Override
	public int size() {
		return this.size;
	}

}
