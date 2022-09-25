import java.io.*;
import java.net.*;

// import javax.swing.text.Document;

import netscape.javascript.JSObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class html_tag_extract{
    public static void main(String[] args) {
        String url_string = "https://www.theguardian.com/world/2022/mar/10/narendra-modi-walks-diplomacy-tightrope-with-vladimir-putin-on-ukraine";
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
                // System.out.println(source);

                Document doc = Jsoup.parse(source);
                Element div = doc.getElementById("maincontent");

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder = null;
                Elements para = div.getElementsByTag("p");
                para.remove(para.last());
                // System.out.println(para);
                // Element first = para.first();
                int length_para = para.size();
                System.out.println(length_para);

                for (int j=0; j<length_para; j++){
                    Element particular = para.get(j);
                    System.out.println(particular.text());

                    System.out.println("\n\n");
                }
            
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