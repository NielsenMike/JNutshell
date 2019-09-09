import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HttpRequest {

    private byte[] response;

    public boolean makeRequest(String urlRequest) {
        if(urlRequest.contains("https://")) {
            try {
                URL url = new URL(urlRequest);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                int status = conn.getResponseCode();
                if(status == 200) {
                    InputStream in = conn.getInputStream();
                    this.response = new byte[in.available()];
                    if(in.read(this.response) == -1){
                        System.out.println("HttpRequest.makeRequest: Could not read response!");
                        return false;
                    }
                }
                else {
                    System.out.println("HttpRequest.makeRequest: Status Error code " + status);
                    return false;
                }
            } catch (IOException ex) {
                ex.printStackTrace();
                return false;
            }
            return true;
        }
        return false;
    }

    public void writeResponseToFile(String pathname){
        try {

            Path path = Paths.get(pathname);
            Files.write(path, this.response);
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }



}
