package 반복제어문2.형성평가08;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
        
        int row =0, column=0;
         
        System.out.println("행의 수를 입력하세요 : ");
        row = sc.nextInt();
         
        System.out.println("열의 수를 입력하세요 : ");
        column = sc.nextInt();
 
        if (row <=0 || column <=0) {
            System.out.println("잘못된 값을 입력하셨습니다.");
            System.out.println("프로그램 종료합니다.");
            System.exit(0);
        }//if end
                 
         
        for (int i =1; i <= row; i++) {            
            for (int j =1; j <= column; j++) {
                System.out.print(i*j+" ");             
            }//inner for end
             
            System.out.println(" ");
        }//outer for end
         
    }
 
}




