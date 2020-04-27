package yunsung;
public class TeamTest {

	  public static void main(String[] args) {
	    // 선수 객체 생성
	    Player1 kim = new Player1("Kim", new int[] { 9, 8, 10 });
	    Player1 lee = new Player1("Lee", new int[] { 10, 9, 10 });
	    Player1 park = new Player1("Park", new int[] { 8, 10, 9 });
	    Player1 Xiao = new Player1("Xiao", new int[] { 10, 9, 10 });
	    Player1 Yu = new Player1("Yu", new int[] { 8, 9, 10 });
	    Player1 Xui = new Player1("Xui", new int[] { 8, 9, 9 });
	    
	    // 객체 배열 만들기
	    Player1[] koreaPlayers = { kim, lee, park };
	    Player1[] chinaPlayers = { Xiao, Yu, Xui};
	    
	    // 팀 객체 생성
	    Team korea = new Team("KOREA", koreaPlayers);
	    Team china = new Team("CHINA" , chinaPlayers);
	    
	    // 팀 점수 출력
	    korea.printTeamPoints();
	    china.printTeamPoints();
	  }
	}

	// 팀 클래스
	class Team {
	  // 필드
	  String nation;    // 나라
	  Player1[] players; // 선수들
	  
	  // 생성자
	  Team (String str, Player1[] arr) {
	    nation = str;
	    players = arr;
	  }
	  
	  // 메소드
	  void printTeamPoints() {
	    int sum = 0;
	    for (int i = 0; i < players.length; i++) {
	      sum += players[i].totalPoints();
	    }
	    System.out.printf("%s -> %d points\n", nation, sum);
	  }
	}

	// 선수 클래스
	 class Player1 {
	  // 필드
	  String name;  // 이름
	  int[] points; // 득점 현황

	  // 생성자
	  Player1 (String str, int[] arr) {
	    name = str;
	    points = arr;
	  }

	  // 메소드
	  int totalPoints() {
	    int sum = 0;
	    for (int i = 0; i < points.length; i++) {
	      sum += points[i];
	    }
	    return sum;
	  }
	}