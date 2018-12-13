package com.thzhima.base.inner;

public class MyLikedListTest {
    public static void main(String[] args) {
		MyList<String> list = new MyLinkedList<>();
		
		list.add("china");
		list.add("english");
		list.add("usa");
		list.add("Japan");
		list.add("aus");
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}
}
