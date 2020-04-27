package yunsung;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Worddiv {
//	문제
//	공백을 포함한 문장을 입력 받아서 홀수 번째 단어를 차례로 출력하는 프로그램을 작성하시오.
//	문장의 길이는 100자 이하이다.
//	입력 예
//	I like you better than him.
//	출력 예
//	I
//	you
//	than
//	Hint!
//	문장을 단어로 나누기

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		StringTokenizer word = new StringTokenizer(str, " ");
		
		
		while(word.hasMoreTokens()) {
			if(word.countTokens() %2 == 0) {
				System.out.println(word.nextToken());
			}else {
				word.nextToken();
			}
		}
//		for (int i = 1; i <= word.countTokens()+1; i++) {
//			if (word.countTokens()+1 % 2 != 0) {
//				System.out.println(word.nextToken());
//			} else {
//				word.nextToken();
//			}
//		}

// while(word.hasMoreTokens()) {
//		for (int i = 0; i < word.countTokens(); i++) {
//			word.
//		}
//	}

//if(word.countTokens() % 2 !=0) {	
//}

	}

}
