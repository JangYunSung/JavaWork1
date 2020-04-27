package phonebook06.db;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

// CONTROLLER 객체
//   어플리케이션의 동작, 데이터 처리(CRUD), (Business logic 담당)

// by 윤지우
public class PhonebookManager implements Pb, Closeable {

	// DB 를 위한 변수들 선언
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Statement stmt = null;

	// singleton적용
	private PhonebookManager() {

		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWD);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// JDBC 프로그래밍
		// 클래스 로딩
		// 연결 Connection
		// Statement (필요하다면) 생성

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

		int cnt = 0;

		// TODO
		// SQL_INSERT 사용하여 INSERT
		// PreparedStatement 사용..
		try {
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, name); // 첫번째 ? 는 1부터 시작!
			pstmt.setString(2, phoneNum);
			pstmt.setString(3, memo);
			cnt = pstmt.executeUpdate(); // DML

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// "INSERT INTO test_member VALUES(?, ?, ?)"

		// pstmt.setString(1, "헐..");
		// pstmt.setString(3, "장윤성");

		return cnt;
	}

	@Override
	public PhonebookModel[] selectAll() {

		List<PhonebookModel> pbList = new ArrayList<PhonebookModel>();
		// SQL_SELECT_ALL 사용
		try {
			pstmt = conn.prepareStatement(SQL_SELECT_ALL);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				String fomat = new SimpleDateFormat("yyyy년MM월dd일").format(rs.getDate(COL_LABEL_REGDATE)) + " "
						+ new SimpleDateFormat("hh:mm:ss").format(rs.getTime(COL_LABEL_REGDATE));

				java.util.Date pb_regdate = new SimpleDateFormat("yyyy년MM월dd일 hh:mm:ss").parse(fomat);

				int pb_uid = rs.getInt(COL_LABEL_UID);
				String pb_name = rs.getString(COL_LABEL_NAME);
				String pb_phonenum = rs.getString(COL_LABEL_PHONENUM);
				String pb_memo = rs.getString(COL_LABEL_MEMO);

				pbList.add(new PhonebookModel(pb_uid, pb_name, pb_phonenum, pb_memo, pb_regdate));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return pbList.toArray(new PhonebookModel[pbList.size()]);
	}

	// 특정 uid 의 데이터 검색 리턴
	// 못찾으면 null 리턴
	@Override
	public PhonebookModel selectByUid(int uid) {

		// TODO : 필수
		try {
			stmt = conn.createStatement();
			String sql_select = "SELECT * FROM phonebook WHERE pb_uid = "+ uid;
			//pb_uid , pb_name, pb_phonenum , pb_memo , pb_regdate
			rs = stmt.executeQuery(sql_select);
			if(rs.next()) {
				return new PhonebookModel(); // (p_uid,p_name, p_num , p_memo , p_date );
			}
				
//			while(rs.next()){
//			 int p_uid = rs.getInt(COL_LABEL_UID);
//			 String p_name = rs.getString(COL_LABEL_NAME);
//			 String p_num = rs.getString(COL_LABEL_PHONENUM);
//			 String p_memo = rs.getString(COL_LABEL_MEMO);
//			 Date p_date = rs.getDate(COL_LABEL_REGDATE);
//			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
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

		int cnt = 0;

		// TODO
		// SQL_UPDATE_BY_UID 사용
		try {
			pstmt = conn.prepareStatement(SQL_UPDATE_BY_UID);
			pstmt.setString(1, name); // 첫번째 ? 는 1부터 시작!
			pstmt.setString(2, phoneNum);
			pstmt.setString(3, memo);
			pstmt.setInt(4, uid);
			cnt = pstmt.executeUpdate(); // DML
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return cnt;
	}

	@Override
	public int deleteByUid(int uid) {
		// 매개변수 검증
		if (uid < 1)
			throw new PhonebookException("deleteByUid() uid 오류: " + uid, Pb.ERR_UID);

		int cnt = 0;

		// TODO
		// SQL_DELETE_BY_UID 사용
		try {
			pstmt = conn.prepareStatement(SQL_DELETE_BY_UID);
			pstmt.setInt(1, uid);
			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return cnt;
	}

	// 현재 데이터중 가장 큰 uid 값을 찾아서 리턴
	private int getMaxUid() {
		int maxUid = 0;

		// TODO : 옵션

		return maxUid;
	}

	@Override
	public void close() throws IOException {

		// TODO
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ResultSet
		// Statement
		// Connection
		// 들 close()..

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
