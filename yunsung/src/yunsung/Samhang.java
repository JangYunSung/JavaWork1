package yunsung;

import java.util.Scanner;

public class Samhang {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println();

		int a;
	
		int max=0;
		int min=0;
		
		while (true) {

			a = sc.nextInt();
			max = (max >= a) ? max  : a; 
			min = (min <= a) ? min  : a; 
			
			
			
			if(a==0) {
				break;
			}
			
//			if (c >= a) {
//
//				c = a;
//
//			}
//
//			if (b < a) {
//
//				b = a;
//
//			}
//
//			if (a == 0) {
//
//				break;
//
//			}
//
//		}


	}
		System.out.print(max + " " + min);

}
}