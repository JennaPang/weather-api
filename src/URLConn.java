import java.net.URL;
import java.net.URLConnection;
import java.net.MalformedURLException;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class URLConn{
    public static void main(String args[]){


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
                System.out.println(buf);
                int a2 = buf.indexOf("temp");
                double temp=Double.parseDouble(buf.substring(a2+6, a2+11))-273.15;
                System.out.println("서울의 현재 온도(섭씨):"+temp);
            }
        }catch(MalformedURLException mue){
            System.err.println("잘못된 URL입니다.");
            System.exit(1);
        }catch(IOException ioe){
            System.err.println("IOException " + ioe);
            ioe.printStackTrace();
            System.exit(1);
        }
    }
}
 