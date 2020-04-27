package com.lec.java.inherit07;

public class BusinessPerson extends Person {

	
	private String company;

	public String getCompany() {return company;}

	public void setCompany(String company) {this.company = company;}
	
	@Override
	public void showInfo() {
		// TODO Auto-generated method stub
		super.showInfo();
		System.out.println("회사: " + company);
	}

	
	public void  showInfo(int id) { 
		System.out.println("id : " + id);
		showInfo();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		super.setName(name);
	}

//	@Override
//	public void whoAreYou() {
//		// TODO Auto-generated method stub
//		super.whoAreYou();
//	}
	
	
	@Override
	public String toString() {
		
		return "BusinessPerson : "+ getName() + " " + company;
	}
	
	
}
