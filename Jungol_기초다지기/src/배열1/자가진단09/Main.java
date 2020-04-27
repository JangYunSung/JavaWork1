package 배열1.자가진단09;

import java.util.Arrays;
import java.util.Scanner;

//10개의 정수를 입력받아 배열에 저장한 후 내림차순으로 정렬하여 출력하시오.
//
//
//입력 예
//95 100 88 65 76 89 58 93 77 99
//출력 예
//100 99 95 93 89 88 77 76 65 58
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] num = new int[10];
		for (int i = 0; i < num.length; i++) {
		num[i] = sc.nextInt();
		}
		for (int i = num.length; i > 0; i--) {
			for (int j = 0; j < i-1; j++) {
				if(num[j] < num[j+1]) {
					int temp = num[j];
					num[j] = num[j+1];
					num[j+1] = temp;
				}
			}
		}
		for (int j = 0; j < num.length; j++) {
			System.out.print(num[j]+ " ");
		}

			
		sc.close();
		}

	}
