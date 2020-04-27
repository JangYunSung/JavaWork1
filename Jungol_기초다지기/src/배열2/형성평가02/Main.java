package 배열2.형성평가02;


//학생들의 점수를 입력을 받다가 0이 입력되면 그 때까지 입력받은 점수를 10점 단위로 구분하여 점수대별 학생 수를 출력하는 프로그램을 작성하시오. (1명도 없는 점수는 출력하지 않는다.)학생은 최대 100명이하이다.
//
//
//입력 예
//63 80 95 100 46 64 88 0
//출력 예
//100 : 1 person
//90 : 1 person
//80 : 2 person
//60 : 2 person
//40 : 1 person
//
//Hint!
//
//10으로 나눈 몫을 기준으로 배열에 넣은 후 출력한다.
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] student = new int[11];
		int sum = 0;
		while (true) {
			int a = sc.nextInt();
			
			if(a!=0) {
			for (int i = 1; i <= 100; i++) {
				 sum = a;
			}
			switch(sum / 10) {
			case 10:
				student[10]++;
				break;
			case 9:
				student[9]++;
				break;
			case 8:
				student[8]++;
				break;
			case 7:
				student[7]++;
				break;
			case 6:
				student[6]++;
				
				break;
			case 5:
				student[5]++;
				
				break;
			case 4:
				student[4]++;
				
				break;
			case 3:
				student[3]++;
				
				break;
			case 2:
				student[2]++;
				
				break;
			case 1:
				student[1]++;
				break;
			case 0:
				student[0]++;	
				break;
			}
		}else {
			break;
		}
	}
		for (int i = 10; i >= 0; i--) {
			if(student[i]!=0) {
			System.out.println(i*10 + " : " + student[i] +" person");
			}
		}
}
}
