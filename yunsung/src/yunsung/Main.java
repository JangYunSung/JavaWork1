package yunsung;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Date;

//영화 예매 내역을 담을 객체를 TicketReservation 이라는 이름의 자바 클래스로 정의하고자 합니다  
//다음과 같은 ‘속성’ 을 가진 클래스를 정의하고,
//기본생성자와 매개변수를 받는 생성자와 getter & setter 를 순서대로 클래스에 작성하세요
//멤버변수 명
//객체의 속성
//uid
//예매 고유한 아이디 값으로 정수타입
//movieId
//예배 영화 id 값, 정수타입
//seatId
//좌석 id 값,  정수타입
//regDate
//예매일, 날짜(Date) 타입


import java.util.Date;
public class Main {

	public static void parse(String str) {

		try {

			float f = Float.parseFloat(str);
			f = 0;
			System.out.println(f);

		} catch (NumberFormatException nfe) {
		} finally {
		}

	}

	public static void main(String[] args) {

		parse("invalid");

	}
}
