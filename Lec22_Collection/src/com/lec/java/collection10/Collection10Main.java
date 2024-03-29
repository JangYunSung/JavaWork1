package com.lec.java.collection10;

import java.util.Iterator;
import java.util.TreeSet;

public class Collection10Main {

	public static void main(String[] args) {
		System.out.println("TreeSet 연습");
		
		// String 타입을 저장할 수 있는 TreeSet 인스턴스 생성
		TreeSet<String> str = new TreeSet<String>();
		// 5개 이상의 데이터를 저장해보고
		str.add("Apple");
		str.add("pineaplle");
		str.add("orange");
		str.add("Cheery");
		str.add("Mango");
		// 오름차순, 내림차순으로 출력해보기
		System.out.println("오름차순");
		Iterator<String> str1 = str.iterator();
		while(str1.hasNext()) {
			System.out.println(str1.next());
		}
		System.out.println();
		System.out.println("내림차순");
		Iterator<String> str2 = str.descendingIterator();
		while(str2.hasNext()) {
			System.out.println(str2.next());
		}
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main

} // end class

















