package practice.game369;
//369게임

//1~100 까지의 자연수를 나열하되,
//10개 단위로 줄바꿈을 하고
//숫자에 3,6,9 중 하나라도 있으면 * 표시를 하기

public class Game369 {
	public static void main(String[] args) {

		// 100개의 열을 가진 배열생성!
		int column = 100;   //행(row)
		int array[] = new int[column]; 
		for (int i = 0; i < array.length; i++) { 
		// array 에 100까지 숫자를 넣고
			array[i] = i+1 ; // 
			int tens = (i+1) / 10;  //십의 자리 tens
			int units = (i+1) % 10; 	//일의 자리 units
			if( 3 == tens || 6 ==tens || 9 ==tens || 3==units || 6==units || 9==units) 
			System.out.print("*" + "\t"); // "*" 을 출력
			else
			System.out.print(array[i] + "\t"); // \t를 해줘서 폭을 일정하게 만들고
			if((i+1)%10==0){// 10으로 나눴을때 0이되면 줄바꿈
				System.out.println();
			}
		}
	}
}
