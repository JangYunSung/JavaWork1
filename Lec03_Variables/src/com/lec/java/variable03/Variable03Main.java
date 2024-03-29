package com.lec.java.variable03;

//실수형 자료 타입: float(4바이트), double(8바이트)
//정수형 자료 타입의 기본형은 int
//실수형 자료 타입의 기본형은 double

public class Variable03Main {

	public static void main(String[] args) {
		System.out.println("변수 - 실수타입");
		//초기화 : 최초의 값을 대입하는것
		double number1 = 3.141592;
//		float number2 = 3.14; // 기본적으로 실수 리터럴은 double 로 인식
		// float <- double 대입 불가 
		
		// float 리터럴
		float number3 = 3.14f;
		
		
		//실수타입 최소, 최대값 
		System.out.println("float :" + Float.MIN_VALUE + " ~ " + Float.MAX_VALUE );
		System.out.println("double :" + Double.MIN_VALUE + " ~ " + Double.MAX_VALUE );
//		float 1.4E-45 ~ 3.4028235E38   == 1.4 * 10의 -45승 ~ 3.4 * 10의 38승
//		double 4.9E-324 ~ 1.7976931348623157E308 == 4.9 * 10의 -324승  ~ 1.7 * 10의 308승

		float number4 = 1.23456789f;
		double number5 = 1.23456789;
		System.out.println("number4 =" + number4 );
		System.out.println("number5 =" + number5 );
		// float 와 double 은 저장할 수 있는 값의 크기만이 아니라
		// 소숫점 이하 정밀도(precision)의 차이가 있다.
		
		// 실수 표기법
		double number6 = 123;
		double number7 = 1.23e2; //지수 표기법(exponential notation)
		System.out.println("number6 = " + number6 );
		System.out.println("number7 = " + number7 );
		
		double number8 = 0.0001213;
		double number9 = 1.213E-4;
		System.out.println("number8 = " + number8 );
		System.out.println("number9 = " + number9 );
		
		
		
		
		
	}

}
