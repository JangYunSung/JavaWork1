package 배열1.자가진단02;


//문제
//정수 10 개를 저장할 수 있는 배열을 만들어서 1 부터 10 까지를 대입하고 차례대로 출력하는 프로그램을 작성하시오.
//
//
//출력 예
//1 2 3 4 5 6 7 8 9 10


public class Main {
public static void main(String[] args) {
	int [] a = new int[10];
	int num = 0;
	int sum = 0;
	for (int i = 0; i < a.length; i++) {
		num++;
		a[i] = num;	
		System.out.print(a[i]+" ");
	} 
}
}
