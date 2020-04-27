package yunsung;

import java.util.Scanner;

public class ArrayFor {

public static void main(String[] args) {

Scanner sc = new Scanner(System.in);
//String a = "";
//String b = "";
//String c = "";
// a = sc.nextLine();
// b = sc.nextLine();
// c = sc.nextLine();

String [] arrfor = new String[3] ;  
String sum = "";

for (int i = 0; i < arrfor.length; i++) {
	arrfor[i] = sc.nextLine();  
	sum += arrfor[i].substring(0,1);
}
	System.out.print(sum);

//System.out.println();
//
//
//
//
//System.out.print(a.substring(0, 1));
//
//System.out.print(b.substring(0, 1));
//
//System.out.print(c.substring(0, 1));

}

}