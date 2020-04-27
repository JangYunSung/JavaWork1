package com.lec.java.crawl03;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl03Main {

	public static void main(String[] args) throws IOException {
	 String url;
	 Response response;
	 Document doc;
	 Element element;
	 Elements elements;

	 url = "https://www.daum.net";
	 response = Jsoup.connect(url).execute();
	 System.out.println(response.statusCode());
	 System.out.println(response.statusMessage());
	 doc = response.parse();
	
	 System.out.println("Daum 인기 검색어");
//	 
//	 
	 elements = doc.select(".slide_favorsch ul li a");
	 System.out.println(elements.size() + " 개 ");
	 
	 for (Element e : elements) {
		System.out.println(e.text().trim());
		System.out.println(e.attr("href"));;
		System.out.println();
	 }
		
	
		
		System.out.println("\n 프로그램 종료");
	}

}
