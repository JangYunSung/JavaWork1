package yunsung;

import java.util.Scanner;

public class SumMain{
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int i =0 ,j =0 ,n,m, num = 1;
	n = sc.nextInt();
	m = sc.nextInt();
	for (i =0; i < n; i++) {
	    for (j = 0; j < m; j++) {
	        System.out.printf("%d ", num++);
	    }
	    System.out.printf("\n");
	}
	
}
	
}
