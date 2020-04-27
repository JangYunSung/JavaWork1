package yunsung;

import java.util.Scanner;
	

public class Printllln {
public static void main(String[] args) {

Scanner sc = new Scanner(System.in);

System.out.println("숫자를 입력하세요 : ");

double a = sc.nextDouble(); 

double b = sc.nextDouble(); 



double sum = (a + b) ;

double goq = (a * b) ;

System.out.printf("합 : %.1f " , sum);

System.out.println();

System.out.printf("곱 : %.1f " , goq);

}

}

