package 배열1.자가진단03;

//문제
//10개의 문자를 입력받아서 첫 번째 네 번째 일곱 번째 입력받은 문자를 차례로 출력하는 프로그램을 작성하시오.
//
//
//입력 예
//A B C D E F G H I J
//출력 예
//A D G
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String[] sum = new String[10];

		for (int i = 0; i < sum.length; i++) {
			sum[i] = sc.next();
			if (i == 0 || i == 3 || i == 6) {
				System.out.print(sum[i]+" ");
			}else {
				
			}
			
		}


	}

}
