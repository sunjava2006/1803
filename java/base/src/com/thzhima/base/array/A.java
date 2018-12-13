package com.thzhima.base.array;

import java.util.Arrays;
import java.util.Comparator;

public class A {
    public static void main(String[] args) {
    	Object[] a = new Object[3];
    	a[1] = "China";
    	a[0] = "English";
    	a[2] = "Japan";
    	
    	
    	
    	for(Object i : a) {
    		System.out.println(i);
    	}
    	
    	System.out.println(a.length);
    	
    	Object[] aa = a.clone();
    	
    	for(Object ii : aa) {
    		System.out.println(ii);
    	}
    	
    	Object[] b = new Object[20];
    	System.out.println("===============================");
    	System.arraycopy(a, 0, b, 3,  3);
    	for(Object o : b) {
    		System.out.println(o);
    	}
    	
    	Object[] aaa = Arrays.copyOf(a, 5);
    	System.out.println("-----------------------------");
    	for(Object o : aaa) {
    		System.out.println(o);
    	}
    	
    	System.out.println("################################");
    	aaa = Arrays.copyOfRange(a, 1, 7 );
    	for(Object o : aaa) {
    		System.out.println(o);
    	}
    	System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
    	
//    	Arrays.fill(aaa, "RUSSINA");
//    	for(Object o : aaa) {
//    		System.out.println(o);
//    	}
    	Arrays.sort(a );
    	Comparator com = new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2) {
				return -((String)o1).compareTo(((String)o2));
			}
    		
		};
		
    	Arrays.sort(a, com);
    	
    	for(Object o : a) {
    		System.out.println(o);
    	}
    	
    	
    	
	}
}
