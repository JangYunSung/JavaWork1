package daily.dailysum;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * 연습 : 자치구단위 서울 생활인구 일별 집계표
 * ■자치구단위 서울 생활인구 일별 집계표
 * 	http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-15379&srvType=S&serviceKind=1&currentPageNo=1
 * 	http://openapi.seoul.go.kr:8088/(인증키)/(요청파일타입)/SPOP_DAILYSUM_JACHI/(요청시작INDEX)/(요청종료INDEX)/(기준일ID)/(시군구코드)
 * 
 * 샘플url
 * 	XML 버젼
 * 	http://openapi.seoul.go.kr:8088/(인증키)/xml/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/20190101
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/20190101/11000
 * 
 * 	JSON 버젼
 * 	http://openapi.seoul.go.kr:8088/(인증키)/json/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/	
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/20190101
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/20190101/11000
 * 
 * ※ 한번에 1000개 까지의 데이터만 볼수 있슴
 * 
 */

/*  입력예]
 *  날짜입력: 20190101
 *  시작Index : 1
 *  끝Index: 5
 *  
 *  [XML]
 *  날짜             구ID        총생활인구수           일최대이동인구수
 *  ----------------------------------------------------------------------
 *  20190101	11000    11121182.98210      4764635.18080 
 *  20190101    11110    274919.65940        177877.95000 
 *  20190101    11140    267096.65940        149729.45840 
 *  20190101    11170    315220.18480        149329.14120 
 *  20190101    11200    351993.77950        153738.94490
 *   
 *  [JSON]
 *  날짜             구ID        총생활인구수           일최대이동인구수
 *  ----------------------------------------------------------------------
 *  20190101	11000    11121182.98210      4764635.18080 
 *  20190101    11110    274919.65940        177877.95000 
 *  20190101    11140    267096.65940        149729.45840 
 *  20190101    11170    315220.18480        149329.14120 
 *  20190101    11200    351993.77950        153738.94490 
 * 
 */

// ★ 주목 ★
// XML 은 Jsoup 를 활용하여 파싱하세요
// JSON 은  jackson 을 활용하여 파싱하세요

public class DailySumMain {
	
	public static final String REQ_SERVICE = "SPOP_DAILYSUM_JACHI";
	public static final String API_KEY = "587159506a61687139356341664149"; // 너의 key 값은?

	public static String buildUrlAddress(String reqType ,int startIndex, int endIndex, String date) {
		
		String url_address = String.format("http://openapi.seoul.go.kr:8088/%s/%s/%s/%d/%d/%s", API_KEY,
				reqType, REQ_SERVICE,startIndex, endIndex,date);
		return url_address;
	}

	public static void main(String[] args) throws IOException {
		
	    String url = buildUrlAddress("xml",1,5,"20190101");
		
		// XML 파싱할때는 xml parser 를 사용한다
		Document doc = Jsoup.connect(url).parser(Parser.xmlParser()).get();
		Elements elements = doc.select("row");
		System.out.println("---------------Jsoup---------------");
		System.out.println("날짜\t\t구ID\t\t총생활인구수\t\t일최대이동인구수");
		for(Element e : elements) {
			String STDR_DE_ID = 
					e.selectFirst("STDR_DE_ID").text().trim();
			String SIGNGU_CODE_SE  =
        			e.selectFirst("SIGNGU_CODE_SE").text().trim();
        	String TOT_LVPOP_CO =
        			e.selectFirst("TOT_LVPOP_CO").text().trim();
        	String DAIL_MXMM_MVMN_LVPOP_CO =
        			e.selectFirst("DAIL_MXMM_MVMN_LVPOP_CO").text().trim();
        	
        	System.out.printf("%s\t\t%s\t\t%s\t\t%s",
        			STDR_DE_ID, SIGNGU_CODE_SE , TOT_LVPOP_CO, DAIL_MXMM_MVMN_LVPOP_CO);
        	System.out.println();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		 URL ur2 = new URL("http://openapi.seoul.go.kr:8088/587159506a61687139356341664149/json/SPOP_DAILYSUM_JACHI/1/5/20190101");
		 A a = mapper.readValue(ur2, A.class);
			
		System.out.println("---------------jackson---------------");	
			System.out.println("날짜\t\t구ID\t\t총생활인구수\t\t일최대이동인구수");
			System.out.println("----------------------------------------------------------------------");
			for(C c : a.getSPOP_DAILYSUM_JACHI().getRow()) {
				System.out.printf("%s\t\t%s\t\t%f\t\t%f ",
						c.getStdrdeid(),
						c.getSigngucodese(), 
						c.getTotlvpopco(),
						c.getDailmaxmm());
				System.out.println();
			}
			
		
		
	} // end main

} // end class
@JsonIgnoreProperties(ignoreUnknown = true)
class A{
	public B SPOP_DAILYSUM_JACHI;  // 왜 이것만 public ???

	public B getSPOP_DAILYSUM_JACHI() {
		return SPOP_DAILYSUM_JACHI;
	}

	public void setSPOP_DAILYSUM_JACHI(B SPOP_DAILYSUM_JACHI) {
		this.SPOP_DAILYSUM_JACHI = SPOP_DAILYSUM_JACHI;
	}
	
	
	
}

@JsonIgnoreProperties(ignoreUnknown = true)
class B{
private int list_total_count;
	
	private List<C> row;

	public int getList_total_count() {
		return list_total_count;
	}

	public void setList_total_count(int list_total_count) {
		this.list_total_count = list_total_count;
	}
	
	public List<C> getRow() {
		return row;
	}

	public void setRow(List<C> row) {
		this.row = row;
	}
	
	
	
}
@JsonIgnoreProperties(ignoreUnknown = true)
class C{
	@JsonProperty("STDR_DE_ID")
	private String stdrdeid;
	@JsonProperty("SIGNGU_CODE_SE")
	private String signgucodese;
	@JsonProperty("TOT_LVPOP_CO")
	private double totlvpopco;
	@JsonProperty("DAIL_MXMM_MVMN_LVPOP_CO")
	private double dailmaxmm;
	public C() {
		super();
	}
	public C(String stdrdeid, String signgucodese, double totlvpopco, double dailmaxmm) {
		super();
		this.stdrdeid = stdrdeid;
		this.signgucodese = signgucodese;
		this.totlvpopco = totlvpopco;
		this.dailmaxmm = dailmaxmm;
	}
	public String getStdrdeid() {
		return stdrdeid;
	}
	public void setStdrdeid(String stdrdeid) {
		this.stdrdeid = stdrdeid;
	}
	public String getSigngucodese() {
		return signgucodese;
	}
	public void setSigngucodese(String signgucodese) {
		this.signgucodese = signgucodese;
	}
	public double getTotlvpopco() {
		return totlvpopco;
	}
	public void setTotlvpopco(double totlvpopco) {
		this.totlvpopco = totlvpopco;
	}
	public double getDailmaxmm() {
		return dailmaxmm;
	}
	public void setDailmaxmm(double dailmaxmm) {
		this.dailmaxmm = dailmaxmm;
	}
	
	
	
	
	
}




