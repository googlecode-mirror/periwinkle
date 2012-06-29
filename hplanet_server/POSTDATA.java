import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class POSTDATA{
  public static void main(String arg[]){

    try {
        // Construct data
        String data = URLEncoder.encode("pname", "UTF-8") + "=" + URLEncoder.encode("Tester", "UTF-8");
        data += "&" + URLEncoder.encode("pscore", "UTF-8") + "=" + URLEncoder.encode("300", "UTF-8");
 
        // Send data
        URL url = new URL("http://localhost/hplanet_server/index.php");
        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);
        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
        wr.write(data);
        wr.flush();
 
        // Get the response
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }
        wr.close();
        rd.close();
    } catch (Exception e) {
    }
  }
}