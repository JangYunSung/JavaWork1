package com.lec.java.class03;

public class Number {
	// 멤버 변수
	private int num;
	private char ch;

	// 생성자
	public Number() {

	}

	// 디폴트 생성자
	public Number(int num, char ch) {
		this.num = num;
		this.ch = ch;
	}

	// 매개변수 있는 생성자

	// 메서드
	// getter: 멤버 변수의 값을 리턴해 주는 메소드
	// setter: 멤버 변수의 값을 변경해 줄 수 있는 메소드
	
	// 일반적인 작명관례
	// get변수이름()
	// set변수이름()
	// Camel notation
	public int getNum() {
		return this.num;
	}

	public void setNum(int num) {
		if (num >= 0) {
			this.num = num;
		}
	}
	public char getCh() {
		return this.ch;
	}
	
	public void setCh(char ch) {
		if (ch >= 0) {
			this.ch = ch;
		}
	}

}
