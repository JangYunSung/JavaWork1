package 반복제어문1.자가진단06;


//아래와 같이 나라 이름을 출력하고 숫자를 입력받아 해당하는
//나라의 수도를 출력하는 작업을 반복하다가 해당하는 번호 이외의 숫자가 입력되면
//"none"라고 출력한 후 종료하는 프로그램을 작성하시오.
//
//* 각 나라의 수도 : 
//대한민국 = 서울(Seoul)
//미국 = 워싱턴(Washington)
//일본 = 동경(Tokyo)
//중국 = 북경(Beijing)
//
//* 입출력시 모양은 "입·출력예"와 같이 하시오.
//1. Korea
//2. USA
//3. Japan
//4. China
//number? 1
//
//Seoul
//
//1. Korea
//2. USA
//3. Japan
//4. China
//number? 5
//
//none​
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int city;
		String a="Seoul";
		String b="Washington";
		String c="Tokyo";
		String d="Beijing";
		String f="none";
		int i = 1;
		while (true) {
			for(int n =1; n<5; n++) {
				if(n==1) {
					System.out.println(n+". Korea");
				}else if(n==2) {
					System.out.println(n+". USA");
				}else if(n==3) {
					System.out.println(n+". Japan");
				}else {
					System.out.println(n+". China");
				}
			}
			System.out.println("number? ");
			city = sc.nextInt();
			if (city == 1) {
				System.out.println(a);
			} else if (city == 2) {
				System.out.println(b);
			} else if (city == 3) {
				System.out.println(c);
			} else if (city == 4) {
				System.out.println(d);
			} else {
				System.out.println(f);
				break;
			}
			System.out.println();
		}
	}
}