package com.lec.java.inherit07;

public class Person {
//	public final class Person {
// final class는 더이상 상속 불가	
	private String name;
	
	public String getName() {return this.name;}
	public void setName(String name) {this.name = name;}
	
	public void showInfo() {
		System.out.println("이름 : " + name);
	}
	// flnal 메소드 : 더이상 오버라이딩 불가
	public final void whoAreYou() {
		System.out.println("이름 : " + name);
		
	}
	
}
