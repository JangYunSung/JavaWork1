package 반복제어문2.자가진단01;


//문제
//문자를 입력받아서 입력받은 문자를 20번 반복하여 출력하는 프로그램을 작성하시오.
//
//
//입력 예
//A
//출력 예
//AAAAAAAAAAAAAAAAAAAA
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String a = sc.nextLine();
		
		for (int i = 1; i <= 20; i++) {
			System.out.print(a);
		}
		
	}
	
}
