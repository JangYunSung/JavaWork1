package com.lec.java.class03;

public class Numeric {

	private char ch;
	private byte operator;
	private int operand1;
	private int operand2;
	
	public Numeric(char ch, byte operator, int operand1, int operand2) {
		super();
		this.ch = ch;
		this.operator = operator;
		this.operand1 = operand1;
		this.operand2 = operand2;
	}
	//멤버 변수
	public char getCh() {
		return ch;
	}

	public void setCh(char ch) {
		this.ch = ch;
	}

	public byte getOperator() {
		return operator;
	}

	public void setOperator(byte operator) {
		this.operator = operator;
	}

	public int getOperand1() {
		return operand1;
	}

	public void setOperand1(int operand1) {
		this.operand1 = operand1;
	}

	public int getOperand2() {
		return operand2;
	}

	public void setOperand2(int operand2) {
		this.operand2 = operand2;
	}
	
	public Numeric() {
		super();
	}
	
	
}
