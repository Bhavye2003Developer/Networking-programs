import java.io.*;
import java.net.*;

// import javax.swing.text.Document;

import netscape.javascript.JSObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

class url_source_code{
    public static void main(String[] args) {
        String url_string = "https://www.theguardian.com/football/2022/sep/09/the-fiver-football-and-the-queen";
        try {
            URL url = new URL(url_string);
            URLConnection uc;
            try {
                uc = url.openConnection();
                InputStream is=uc.getInputStream();
                int i;
                StringBuilder sb=new StringBuilder();  
                while((i=is.read())!=-1){  
                    sb.append((char)i);  
                }
                String source=sb.toString();  
                System.out.println(source);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }  

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}