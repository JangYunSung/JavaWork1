package 반복제어문1.자가진단02;

import java.util.Scanner;

//문제
//100 이하의 양의 정수만 입력된다. while 문을 이용하여 1부터 입력받은 정수까지의 합을 구하여 출력하는 프로그램을 작성하시오.
//
//
//입력 예
//10
//출력 예
//55
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		int num = sc.nextInt();

		int i = 1;
		int sum = 0;
		while (i <= num) {
			sum += i;
			i++;
		}
		System.out.println(sum);
	}

}
