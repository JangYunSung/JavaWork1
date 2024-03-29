package com.lec.java.crawl05;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * 검색어 입력 받아서,
 * 첫페이지의 '국내도서' 카테고리 20개 아이템 크롤링
 *    책이름, 책가격, 상세페이지 주소, 썸네일 주소 
 * 
 * yes24.com 검색페이지는 euc-kr 로 URL 인코딩 되어있다.
 *       한글 한글자당 2바이트 인코딩
 * 
 */


public class Crawl05Main {

   private static final String PATH = "books";
   
   public static void main(String[] args) throws IOException {
      System.out.println("yes24.com 책 정보 검색결과");
      
      Scanner sc = new Scanner(System.in);
      System.out.print("검색어를 입력하세요: ");
      String search = sc.nextLine();
      sc.close();
      
      Crawl05Main app = new Crawl05Main();
      ArrayList<InfoBook> list = app.crawlYes24(search); // 검색어 입력 받아서 검색!! 
      
      // 썸네일 이미지 다운로드 받아서
      // thumb001.jpg ~ thumb020.jpg...
      
      int fileIndex = 1;
      for(InfoBook e :list) {
         System.out.println(e); // 크롤링 정보 출력
      
         //썸네일 이미지 다운로드
         String fileName = String.format(PATH + File.separator + "thumb%03d.jpg", fileIndex);
         URL imgUrl = new URL(e.getImgUrl());
         
         BufferedImage imgData = ImageIO.read(imgUrl);
         File file = new File(fileName);
         ImageIO.write(imgData, "jpg", file);
         System.out.println(fileName + " 이 저장되었습니다.");
         
         fileIndex++;
      }
      
      System.out.println("\n프로그램 종료");
      
   }// main() end
   
   
   

   private ArrayList<InfoBook> crawlYes24(String search) throws IOException {
      ArrayList<InfoBook> list = new ArrayList<InfoBook>();
      
      String url;
      Document doc;
      Response response;
      Element element;
      Elements rowElements;
      
      url = "http://www.yes24.com/searchcorner/Search?keywordAd=&keyword=&domain=ALL&qdomain=%C0%FC%C3%BC&query=" 
            + URLEncoder.encode(search, "euc-kr");
//      System.out.println(url); // 확인용
      
      doc = Jsoup.connect(url).execute().parse();
      
      rowElements = doc.select("#schMid_wrap > div.goods_list_wrap.mgt30").get(0).select("tr:nth-child(odd)");
      
      System.out.println(rowElements.size()); // 확인용
      
      for(Element e : rowElements) {
         
         String imgUrl = e.selectFirst("td.goods_img > a > img").attr("src").trim();
         System.out.println(imgUrl);
         
         Element infoElement = e.selectFirst("td.goods_infogrp > p.goods_name > a");
         
         String bookTitle = infoElement.text().trim();
         String linkUrl = "Http://www.yes24.com/" + infoElement.attr("href").trim();
         double price = Double.parseDouble(
         e.selectFirst("td.goods_infogrp > div.goods_price > em.yes_b").text().trim().replace(",", ""));
         
         System.out.println(bookTitle + " : " + linkUrl);
         System.out.println(price + "원"); // 확인용
         
         
         list.add((new InfoBook(bookTitle, price, linkUrl, imgUrl)));
      }
      
      //TODO
      //#schMid_wrap > div:nth-child(3)
      //http://www.yes24.com/searchcorner/Search?keywordAd=&keyword=&domain=ALL&qdomain=%C0%FC%C3%BC&query=%C6%C4%C0%CC%BD%E3
      
      return list;
      
   }// crawlYes24() end
   
}// class end