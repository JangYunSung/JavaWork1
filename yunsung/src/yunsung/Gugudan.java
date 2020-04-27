package yunsung;

//출력형식
//시작 범위와 끝 범위사이의 구구단을 출력하되 모든 값과 부호 사이는 공백으로 구분하여 아래 출력 예와 같이 줄을 맞추어 출력해야 한다.
//
//구구단 사이는 3개의 공백으로 구분한다. 
//
//데이터의 크기가 주어진 범위를 벗어날 경우는 "INPUT ERROR!"를 출력하고 s와 e를 다시 입력받는다.
//
//
//입력 예
//4 3
//출력 예
//4 * 1 =  4   3 * 1 =  3
//4 * 2 =  8   3 * 2 =  6
//4 * 3 = 12   3 * 3 =  9
//4 * 4 = 16   3 * 4 = 12
//4 * 5 = 20   3 * 5 = 15
//4 * 6 = 24   3 * 6 = 18
//4 * 7 = 28   3 * 7 = 21
//4 * 8 = 32   3 * 8 = 24
//4 * 9 = 36   3 * 9 = 27
import java.util.Scanner;

public class Gugudan {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int i = 1;
		while (true) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			System.out.println();
			if (num1 != 0) {
				for (i = 1; i <= 9; i++) {
					int a = num1 * i;
					int b = num2 * i;
					if (a < 10) {
						System.out.print(num1 + " * " + i + " =  " + a);
					} else {
						System.out.print(num1 + " * " + i + " = " + a);
					}
					for (int j = 1; j <= 1; j++) {
						if (b < 10) {
							System.out.println("   " + num2 + " * " + i + " =  " + b);
						} else {
							System.out.println("   " + num2 + " * " + i + " = " + b);

						}
					}
				}
			}

		}

	}
}
