package yunsung;

import java.util.Scanner;

public class Weekdayyoil {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println();

		int a = sc.nextInt();
		
		
		switch(a) {
		case 0:
			System.out.println("일요일");
			break;
		case 1:
			System.out.println("월요일");
			break;
		case 2:
			System.out.println("화요일");
			break;
		case 3:
			System.out.println("수요일");
			break;
		case 4:
			System.out.println("목요일");
			break;
		case 5:
			System.out.println("금요일");
			break;
		case 6:
			System.out.println("토요일");
			break;
		default:
			System.out.println("잘못 입력하셨습니다");
		}

//if(a==0) {
//
//System.out.println("일요일");
//
//}else if(a==1) {
//
//System.out.println("월요일");
//
//}else if(a==2) {
//
//System.out.println("화요일");
//
//}else if(a==3) {
//
//System.out.println("수요일");
//
//}else if(a==4) {
//
//System.out.println("목요일");
//
//}else if(a==5) {
//
//System.out.println("금요일");
//
//}else if(a==6) {
//
//System.out.println("토요일");
//
//}else {
//
//System.out.println("잘못 입력하셨습니다");
//
//}

	}

}
