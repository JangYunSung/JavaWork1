package practice.cardcompany;



public class Company {   
	
	public Card createCard() {return new Card();}
	// 자신의 인스턴스 생성
    private static Company instance = new Company(); 
    //생성자 호출제한
    private Company() {}
    //메서드 정의
    public static Company getInstance(){
    	return instance;//생성한 인스턴스 리턴
    	}
								
	

    

	
	

} // end class











