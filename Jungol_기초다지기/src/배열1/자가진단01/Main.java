package 배열1.자가진단01;


//문제
//문자 10개를 저장할 수 있는 배열을 만들고 10개의 문자를 입력받아 입력받은 문자를 이어서 출력하는 프로그램을 작성하시오.
//
//
//입력 예
//A B C D E F G H I J
//출력 예
//ABCDEFGHIJ
//
//Hint!
//
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String [] a = new String [10];
		String str;
		String sum = ""; 
		int i =0;
		for (i = 0; i < a.length; i++) {
			str =  sc.next();
			a[i] =  str;
			sum += a[i];
		}
		System.out.print(sum);
		
	}
}
