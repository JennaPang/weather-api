import java.net.URL;
import java.net.URLConnection;
import java.net.MalformedURLException;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class URLConn{
	private double temperature;
	private double humidity;
	private double minTemp;
	private double maxTemp;
	private double sunrise;
	private double sunset;
	private double wind;
	private int err=0;
	
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
		sunrise = Double.parseDouble(buf.substring(temp+9, temp+18));
	}
	
	public double getSunrise() {
		return sunrise;
	}
	
	public void setSunset(String buf) {
		int temp = buf.indexOf("sunset");
		sunset = Double.parseDouble(buf.substring(temp+9, temp+18));
	}
	
	public double getSunset() {
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
 