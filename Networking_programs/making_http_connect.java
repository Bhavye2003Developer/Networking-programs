import java.io.*;
import java.net.*;
class making_http_connect{
    public static void main(String[] args) {
        System.out.println("Working...\n");

        String URL_string = "https://content.guardianapis.com/search?q=football&api-key=e283ed76-57f6-48d0-a20a-87be5220e241";  //URL YOU WANT TO FETCH DATA FROM

        StringBuilder sb = new StringBuilder(); // to get data on url
        try {
            URL url  = new URL(URL_string); // CREATE URL OBJECT
            HttpURLConnection urlcon=(HttpURLConnection)url.openConnection(); // MAKING HTTP CONNECTION
            if (urlcon.getResponseCode()==HttpURLConnection.HTTP_OK){
                InputStream stream=urlcon.getInputStream();    
                int i;    
                while((i=stream.read())!=-1){    
                    sb.append((char)i);    
                }
            }
            else{
                System.out.println("Unable to connect : " + Integer.toString(urlcon.getResponseCode()));
            }
        }catch(Exception e){System.out.println(e);}
        System.out.println(sb);
    }
}