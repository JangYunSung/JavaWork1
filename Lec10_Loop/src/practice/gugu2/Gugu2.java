package practice.gugu2;

public class Gugu2 {

	public static void main(String[] args) {
		// 구구단 3행 3열
		int dan = 2;

		for (dan = 2; dan <= 9; dan += 3) {
			for (int i = 0; i < 3; i++) {
				System.out.print(dan + i < 10 ? " <" + (dan + i) + "단>\t" : "");
			}
			System.out.println();
			for (int i = 1; i <= 9; i++) {
				for (int j = 0; j < 3; j++) {
					String str = (dan + j) + "*" + i + "=" + (dan + j) * i;
					System.out.print(dan + j < 10 ? str + "\t" : "");
				}
				System.out.println();
			}
		}

	}
		 

		}