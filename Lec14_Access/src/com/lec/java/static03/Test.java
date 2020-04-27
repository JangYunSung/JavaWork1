package com.lec.java.static03;

public class Test {
	private int num;
	
	static int count = 0;
	
	
	
	// singleton 패턴
	//기본 생성자
	private Test() {
		count++;
		System.out.println(count+"번째 인스턴스 생성");
	}
		
	private static Test instance = null;
	public static Test getInstance() {
		if(instance == null) {
			instance = new Test(); //인스턴스 생성!
		}
		return instance;
	}
	
	

	//getter
	public int getNum() {return num;
	}
	//setter
	public void setNum(int num) {this.num = num;
	}
	
	
}
