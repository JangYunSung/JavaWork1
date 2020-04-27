package com.lec.java.inherit03;


//하나의 부모한테만 상속을 받는다
// 다중상속이 안된다.
public class BusinessPerson extends Person {

	String company;
	
	
	public void showInfo() {
		whoAmI();
		System.out.println("회사는 "+company+" 입니다");
	}
}
