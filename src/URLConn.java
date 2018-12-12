import java.net.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.*;


public class URLConn{
	private double temperature;
	private double humidity;
	private double minTemp;
	private double maxTemp;
	private String sunrise;
	private String sunset;
	private double wind;
	private int err=0;

	public static void main(String[] args) {
		URLConn u = new URLConn();
		System.out.println(u.getSunrise());
	}
	
	
	public URLConn() {
		URL url;//URL 주소 객체
        URLConnection connection;//URL접속을 가지는 객체

        InputStream is;//URL접속에서 내용을 읽기위한 Stream
        InputStreamReader isr;
        BufferedReader br;

        try{
            //URL객체를 생성하고 해당 URL로 접속한다..
            url = new URL("http://api.openweathermap.org/data/2.5/weather?id=1835848&APPID=02c03632dd04c4103fb74e8c5206f5ca");
            connection = url.openConnection();
            //내용을 읽어오기위한 InputStream객체를 생성한다..
            is = connection.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            //내용을 읽어서 화면에 출력한다..
            String buf = null;
            while(true){
                buf = br.readLine();
                if(buf == null) break;
                setTemp(buf);
                setHumidity(buf);
                setMinTemp(buf);
                setMaxTemp(buf);
                setSunrise(buf);
                setSunset(buf);
                setWind(buf);
            }
        }catch(MalformedURLException mue){
            err=1;
            System.exit(1);
        }catch(IOException ioe){
            err=1;
            System.exit(1);
        }
	}
	
	public void setTemp(String buf) {
		int temp = buf.indexOf("temp");
		temperature=Double.parseDouble(buf.substring(temp+6, temp+11))-273.15;
	}
	
	public double getTemp() {
		return temperature;
	}
	public void setHumidity(String buf) {
		int temp = buf.indexOf("humidity");
		humidity = Double.parseDouble(buf.substring(temp+10, temp+11));
	}
	
	public double getHum() {
		return humidity;
	}
	
	public void setMinTemp(String buf) {
		int temp = buf.indexOf("temp_min");
		minTemp = Double.parseDouble(buf.substring(temp+10, temp+15)) - 273.15;
	}
	
	public double getMinTemp() {
		return minTemp;
	}
	
	public void setMaxTemp(String buf) {
		int temp = buf.indexOf("temp_max");
		maxTemp = Double.parseDouble(buf.substring(temp+10, temp+15)) - 273.15;
	}
	
	public double getMaxTemp() {
		return maxTemp;
	}
	
	public void setSunrise(String buf) {
		int temp = buf.indexOf("sunrise");
		long sun = Long.parseLong(buf.substring(temp+9, temp+18));
		Date date = new java.util.Date(sun*1000L);
		SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm"); 
		sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT+9")); 
		sunrise = sdf.format(date);
	}
	
	public String getSunrise() {
		return sunrise;
	}
	
	public void setSunset(String buf) {
		int temp = buf.indexOf("sunset");
		long sun = Long.parseLong(buf.substring(temp+9, temp+18));
		Date date = new java.util.Date(sun*1000L);
		SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm"); 
		sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT+9")); 
		sunset = sdf.format(date);
	}
	
	public String getSunset() {
		return sunset;
	}
	
	public void setWind(String buf) {
		int temp = buf.indexOf("speed");
		wind = Double.parseDouble(buf.substring(temp+7, temp+10));
	}
	
	public double getWind() {
		return wind;
	}	
}
 