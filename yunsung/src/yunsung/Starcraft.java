package yunsung;

public class Starcraft {
	public static void main(String[] args) {
		// 객체 생성
		Marine ma = new Marine("레이너", 80);
		Medic me = new Medic("모랄레스", 60, 60);
		// 마린 스팀팩 버프~
		ma.stimpack();
		// 메딕의 치료 -> 마린
		me.heal(ma);
	}
}

// 마린 클래스
class Marine {
	// 필드
	String name;
	int hp;

	// 생성자
	public Marine(String n, int h) {
		this.name = n;
		this.hp = h;
	}

	// 메소드
	public void stimpack() {
		System.out.printf("[%s]의 스팀팩! HP %d ", name, hp);
		hp -= 10;
		System.out.printf("-> %d", hp);
		System.out.println();

	}

}

// 메딕 클래스
class Medic {
	// 필드
	String name;
	int hp;
	int mp;

	// 생성자
	public Medic(String n, int h , int m) {
		this.name = n;
		this.hp = h;
		this.mp = m;
	}
	// 메소드
	public void heal(Marine target) {
		System.out.printf("[%s]의 힐! [%s]의 HP %d " , name , target.name , target.hp);
		target.hp += 10;
		System.out.printf("=> %d " , target.hp);
		System.out.println();
	}
	
	
}
