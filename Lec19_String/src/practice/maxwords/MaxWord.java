package practice.maxwords;

//import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/* MaxWrod
	여러문장으로 구성된 문자열을 입력받은뒤 
	문자열에서 가장 단어의 개수가 많은 문장을 찾아서, 
	그 문장과 문장의 단어의 개수를 출력
	'문장'의 구분은  .(마침표) !(느낌표) ?(물음표) 로 한다.
	'단어'구분은 '공백' 으로 한다
	
	입력예]
	We test coders. Give us a try. Can you make it out? It's awesome.
	
	출력예]
	5개
	Can you make it out
 */
public class MaxWord {

	// TODO : 필요한 메소드 있으면 추가 작성

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str =  sc.nextLine();
		String ma= "";
		String ma2= "";
		StringTokenizer aaa = new StringTokenizer(str , ".?!");
		int countTokens = aaa.countTokens();
		int max =0;
		String an =null;
		
		for (int i = 1; i <= countTokens ; i++) {
			String token = aaa.nextToken();
			int idx = token.indexOf(".?!");
			ma = token.substring(idx+1);
			ma2 = ma.trim();
			System.out.println("문장 : " +ma2);
			String[] a = ma2.split("\\s+");
			System.out.print("문장의 단어 : ");
			int j =0;
			for(j=0; j<a.length; j++) {
				System.out.print(a[j]+", ");
			}
			
			
			System.out.println();
			System.out.println("단어의 갯수 : "+ a.length);
			
			if(max < a.length) {
			max=a.length;
			an = ma2;
			}
			System.out.println();
		}
		System.out.println("가장 긴 문장은: "+ an);
			
		sc.close();
	} // end main

}// end class
