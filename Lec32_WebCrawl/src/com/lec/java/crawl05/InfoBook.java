package com.lec.java.crawl05;

public class InfoBook {
	private String bookTitke;  //책제목
	private double price;     // 책가격
	private String url;      // 상세페이지 url
	private String imgUrl; 	 // 썸네일  url
	public InfoBook() {
		super();
	}
	public InfoBook(String bookTitke, double price, String url, String imgUrl) {
		super();
		this.bookTitke = bookTitke;
		this.price = price;
		this.url = url;
		this.imgUrl = imgUrl;
	}
	public String getBookTitke() {
		return bookTitke;
	}
	public void setBookTitke(String bookTitke) {
		this.bookTitke = bookTitke;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}


	@Override
	public String toString() {
		return bookTitke + " : " + price + "원 , URl :" + url + " ,img : " +imgUrl;
	}
	
	
	
	
	
	
}
