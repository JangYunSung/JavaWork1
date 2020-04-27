package yunsung;
public class Crawlnavermovie {

public static void main(String[] args) throws IOException {

String url;

Response response;
Document doc;
Element element;
Elements elements;

url = "https://movie.naver.com/movie/sdb/rank/rmovie.nhn";
response = Jsoup.connect(url).execute();
doc = response.parse();

elements = doc.select("#assistant > div:nth-child(1) > ul > li > a");
 
for (Element e : elements) {

System.out.println(e.text().trim());
}
System.out.println("\n 프로그램 종료");

}

}
