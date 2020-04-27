package com.lec.java.if05;

import java.util.Scanner;

/* 중첩된 if (nested-if) 문
 *   조건문 안의 조건문
 */
public class If05Main {

	public static void main(String[] args) {
		System.out.println("중첩된 if (nested-if) 문");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		if (num % 2 == 0) {
			System.out.println("짝수");
		
			if (num % 4 == 0) {
				System.out.println("4의 배수입니다");
			}else {
				System.out.println("짝수이지만, 4의 배수는 아닙니다.");
			}
		
		}else {
			System.out.println("홀수");
			
			if ( num % 3 == 0) {
				System.out.println("3의 배수입니다");
			}else {
				System.out.println("홀수이지만 3의 배수는 아닙니다");
			}
		}
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class









