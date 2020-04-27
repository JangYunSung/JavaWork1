package practice.cardcompany;

public class Card {

	private static int Num=10000; //변하지 않는수로 지정
	private int cardNumber; 
	public Card() {Num++; cardNumber=Num;}
	public int getCardNumber() {return this.cardNumber;}
	
}