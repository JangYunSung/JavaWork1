package com.lec.java.collection02;

import java.util.ArrayList;
import java.util.Iterator;

public class Collection02Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");
		//TODO:
		// String 타입을 담는 ArrayList를 만들고
		ArrayList<String> list1 = new ArrayList<String>();
		// 5개 이상의 String을 저장하고
		list1.add("abc");
		list1.add("cable");
		list1.add("123");
		list1.add("Hello");
		list1.add("Java");
		// set(), remove() 등의 메소드 사용하여
		// 임의의 것을 수정, 삭제 도 해보시고
		list1.set(2, "bible");
		list1.remove(0);
		// 3가지 방식으로 출력해보세요
		//  for,
		System.out.println("for");
		for (int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i));
		}
		System.out.println("Enhanced-for");
		// "Enhanced-for",
		for (String e : list1) {
			System.out.println(e);
		}
		//Iterator
		System.out.println();
		System.out.println("Iterator");
		Iterator<String>str = list1.iterator();
		while(str.hasNext()) {
			System.out.println(str.next());
		}
		


		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class












