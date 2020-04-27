package practice.stddev;

import java.util.Random;

public class StdDev {

	public static void main(String[] args) {

		Random rand = new Random();
		int[] intArr = new int[5]; // 정수 5개 담는 배열
		int sum = 0; // 평균 합계변수
		for (int i = 0; i < intArr.length; i++) {
			intArr[i] = rand.nextInt(100) + 1;
			sum += intArr[i]; // 합계에 누적
			System.out.print(intArr[i] + " "); // 난수 출력
		} // end for
		double a = calcAvg(intArr);
		double b = calcVariance(intArr,a);
		calcStdDev(intArr,b);

		// 임의정수 5개로 초기화한 정수로
		// 평균, 분산, 표준편차 구하기

	} // end main

	/**
	 * 메소드 이름 : calcAvg 매개변수 : int [] 리턴값 : double
	 * 
	 * 주어진 배열의 '평균값' 리턴
	 */
	public static double calcAvg(int[] score) {
		int total = 0;

		for (int x : score) {
			total += x;
		}
		double average = (double) total / score.length;
		System.out.printf("평균 = %.1f\n", average);
		return average;
	}

	/**
	 * 메소드 이름 : calcVariance 매개변수 : int [] 리턴값 : double
	 * 
	 * 주어진 배열의 '분산값' 리턴
	 */
	public static double calcVariance(int[] score, double a) {
		double dev = 0; // 분산, 표준편차를 위해 편차변수 설정
		double devSqvSum = 0; // 편차제곱합
		//double avg = 0; // 평균
		double var; // 분산
		
		for (int i = 0; i < score.length; i++) {
			dev = (score[i] - a); // 편차를 구하고,
			devSqvSum += Math.pow(dev, 2); // 편차제곱합에 누적시킴
		} // end for
		
		var = devSqvSum / score.length; // 분산 도출 
		System.out.printf("분산 = %.2f\n", var);

		return var;
	}
	

	/**
	 * 메소드 이름 : calcStdDev
	 *  매개변수 : int [] 리턴값 : double
	 * 
	 * 주어진 배열의 '표준편차' 리턴
	 */
	public static double calcStdDev(int[] var, double s) {
		double std = Math.sqrt(s); // 표준편차 도출

		System.out.print("표준편차:" + std);
		return std;
	}
} // end class
