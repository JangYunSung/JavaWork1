package phonebook04.list;

import java.util.ArrayList;
import java.util.Date;

// CONTROLLER 객체
//   어플리케이션의 동작, 데이터 처리(CRUD), (Business logic 담당)
public class PhonebookManager implements Pb {
					// 폰북리스트는 폰북모델타입의 어레이 리스트 
					// ArrayList<PhonebookModel> pbList
	private ArrayList<PhonebookModel> pbList = new ArrayList<PhonebookModel>();
													//폰푹모델 타입의 어레이리스트 생성자
	// singleton적용
	private PhonebookManager() {
	}

	private static PhonebookManager instance = null;

	public static PhonebookManager getInstance() {
		if (instance == null) {
			instance = new PhonebookManager();
		}
		return instance;
	} // end getInstance()

	// 전화번호부 생성 등록
	@Override
	public int insert(String name, String phoneNum, String memo) {

		// 매개변수 검증 : 이름 필수
		if (name == null || name.trim().length() == 0) {
			throw new PhonebookException("insert() 이름입력오류: ", Pb.ERR_EMPTY_STRING);
		}
		// 한번에 선언하며 초기화면 순서대로 입력해야한다.
//		pbList.add(new PhonebookModel((getMaxUid()+1),name,phoneNum,memo,new Date()));
		PhonebookModel ppl = new PhonebookModel(name , phoneNum , memo); 
		ppl.setUid(getMaxUid()+1);
		pbList.add(ppl); 
		return 1;
	}

	@Override
	public PhonebookModel[] selectAll() {  //폰북리스트크기만큼 폰북모델배열 pbl 생성
		PhonebookModel[] pbl = new PhonebookModel[pbList.size()]; 
		for (int i = 0; i < pbList.size(); i++) {   //폰북리스트의 크기만큼 반복하고 
			pbl[i] = pbList.get(i);		//폰북리스트에 i번째 정보를 pbl배열 i번째 저장
	 

		}
		return pbl; //pbl값으로 리턴한다
	}			//return 

	// 특정 uid 의 데이터 검색 리턴
	// 못찾으면 null 리턴
	@Override
	public PhonebookModel selectByUid(int uid) {

		for (int i = 0; i < pbList.size(); i++) {
			if (pbList.get(i).getUid()==uid) {
				return pbList.get(i);
			}
			
		} 
		return null; // 못찾으면 null 리턴
	}// end selectByUid()

	@Override
	public int updateByUid(int uid, String name, String phoneNum, String memo) {

		// 매개변수 검증
		if (uid < 1)
			throw new PhonebookException("update() uid 오류: " + uid, Pb.ERR_UID);
		if (name == null || name.trim().length() == 0) // 이름 필수
			throw new PhonebookException("update() 이름입력 오류: ", Pb.ERR_EMPTY_STRING);

		// 특정 uid 값을 가진 데이터의 배열 인덱스 찾기
		int index = findIndexByUid(uid);
		if (index < 0)
			throw new PhonebookException("update() 없는 uid: " + uid, Pb.ERR_UID);
		
//		pbList.set(index, new PhonebookModel(name , phoneNum , memo));
//		pbList.get(index).setUid(uid);
		pbList.get(index).setMemo(memo);
		pbList.get(index).setName(name);
		pbList.get(index).setPhoneNum(phoneNum);
		
		
//		pbList.get(index).setName(name);
//		pbList.get(index).setMemo(memo);
//		pbList.get(index).setPhoneNum(phoneNum);
		// 폰북 리스트에서 인덱스를 찾고 정해진 값을 바꾼다
		return 1;
	}

	@Override
	public int deleteByUid(int uid) {
		// 매개변수 검증
		if (uid < 1)
			throw new PhonebookException("deleteByUid() uid 오류: " + uid, Pb.ERR_UID);

		int index = findIndexByUid(uid);
		if (index < 0)
			throw new PhonebookException("deleteByUid() 없는 uid: " + uid, Pb.ERR_UID);

		pbList.remove(index);

		return 1;
	}

	// 현재 데이터중 가장 큰 uid 값을 찾아서 리턴
	private int getMaxUid() {
		int maxUid = 0;    //폰북리스트 크기만큼 돌고
		for (int i = 0; i < pbList.size(); i++) {
			if(maxUid < pbList.get(i).getUid()) {
				maxUid = pbList.get(i).getUid();
			}
		}
		return maxUid;
	}

	// 특정 uid 값을 가진 데이터의 배열 인덱스 찾기
	// 못찾으면 -1 리턴
	private int findIndexByUid(int uid) {
		for (int i = 0; i < pbList.size(); i++) {
			if(pbList.get(i).getUid()==uid) {
				return i;
			}
		}
		return -1;
	}

} // end PhonebookManager

// 예의 클래스 정의
// 예외발생하면 '에러코드' + '에러메세지'를 부여하여 관리하는게 좋다.
class PhonebookException extends RuntimeException {

	private int errCode = Pb.ERR_GENERIC;

	public PhonebookException() {
		super("Phonebook 예외 발생");
	}

	public PhonebookException(String msg) {
		super(msg);
	}

	public PhonebookException(String msg, int errCode) {
		super(msg);
		this.errCode = errCode;
	}

	// Throwable 의 getMessage 를 오버라이딩 가능
	@Override
	public String getMessage() {
		String msg = "ERR-" + errCode + "]" + Pb.ERR_STR[errCode] + " " + super.getMessage();
		return msg;
	}

} // end PhonebookException
