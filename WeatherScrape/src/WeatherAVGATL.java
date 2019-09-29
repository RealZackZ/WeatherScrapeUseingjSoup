import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class WeatherAVGATL {
/*
CODE OUTPUT

Atlanta, GA Weather Forecast and Conditions - The Weather Channel | Weather.com
76 F
Atlanta Weather | WSB-TV
77 F
Atlanta, GA Forecast | Weather Underground
78 F
The Adverage is 77 F
*/

	public static void main(String[] args) throws Throwable{
		// TODO Auto-generated method stub
		int numberOfWeatherInputs = 0;
		
		Document doc1 = Jsoup.connect("https://weather.com/weather/today/l/USGA0028:1:US").get(); //connect to url
        	System.out.println(doc1.title()); //print title of page
	   	Elements weather1 = doc1.getElementsByClass("today_nowcard-temp"); //Class thats contains temperature on webpage
	   	String weather1ToString = weather1.text();  //Convert to String 
  	  	weather1ToString = weather1ToString.replaceAll("(^[-])[^0-9]", "");  //Regrex 0-9 and - incase weather is below 0
  	    	int degrees1 = Integer.parseInt(weather1ToString); //convert String to Int
  	   	System.out.println(degrees1 + " F");//
	    	numberOfWeatherInputs++; // added to find avg of temperatures 

	    
	  	Document doc2 = Jsoup.connect("https://www.wsbtv.com/weather").get();
        	System.out.println(doc2.title());
       		Elements weather2 = doc2.getElementsByClass("temp");
    		String weather2ToString = weather2.text();
  	   	weather2ToString = weather2ToString.replaceAll("(^[-])[^0-9]", "");
  	   	int degrees2 = Integer.parseInt(weather2ToString);
  	   	System.out.println(degrees2 + " F");
    		numberOfWeatherInputs++;
    	

    		Document doc3 = Jsoup.connect("https://www.wunderground.com/weather/us/ga/atlanta?cm_ven=localwx_today").get();
       		System.out.println(doc3.title());
      		Elements weather3 = doc3.getElementsByClass("current-temp");
 	    	String weather3ToString = weather3.text();
 	   	weather3ToString = weather3ToString.replaceAll("(^[-])[^0-9]", "");
 	    	int degrees3 = Integer.parseInt(weather3ToString);
  	    	System.out.println(degrees3 + " F");
 	    	numberOfWeatherInputs++;
 	    
 	   	double adverageTemp =Math.round((double)(degrees1+degrees2+degrees3)/numberOfWeatherInputs); //Finds adverage 
 	   	System.out.println("The Adverage is " + (int) adverageTemp + " F");//cast back to int for proper form 
	}

}
