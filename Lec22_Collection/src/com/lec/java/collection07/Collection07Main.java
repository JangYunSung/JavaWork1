package com.lec.java.collection07;

import java.util.HashSet;
import java.util.Iterator;

public class Collection07Main {

	public static void main(String[] args) {
		System.out.println("HashSet 연습");
		
		// String 타입을 저장할 수 있는 HashSet 를 생성하고
		HashSet<String> str = new HashSet<String>();
		// 5개 이상의 데이터는 저장, 수정, 삭제 등의 동작을 해보고,
		str.add("benz");
		str.add("kia");
		str.add("audy");
		str.add("bmw");
		str.add("hyundae");
		
		str.remove("audy");
		str.add("chevroret");
		// iterator, enhanced-for 문을 사용해서 출력해보기
		for (String e : str) {
			System.out.println(e);
		}
		System.out.println();
		Iterator<String> s = str.iterator();
		while(s.hasNext()) {
			System.out.println(s.next());
		}
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
















