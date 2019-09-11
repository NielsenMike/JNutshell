import netscape.javascript.JSObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class WeatherStream {

    class WeatherData{
        public String city;
        public String type;
        public String description;
        public String temperature;
    }

    enum UnitsForm{
        standard,
        metric,
        imperial
    }

    private String openWeatherURL;
    private String apiKey;
    private UnitsForm unitsForm;


    public WeatherStream(String apiKey, UnitsForm unitForm)
    {
        this.openWeatherURL = "https://api.openweathermap.org/data/2.5/weather?";
        this.apiKey = apiKey;
        this.unitsForm = unitForm;
        this.openWeatherURL = this.openWeatherURL.concat("APPID=" + this.apiKey);
        this.openWeatherURL = this.openWeatherURL.concat("&units=" + this.unitsFormToString(this.unitsForm));
    }

    public void writeRequestFile(String city, String pathname) {
        this.openWeatherURL = this.openWeatherURL.concat("&q=" + city);
        HttpRequest request = new HttpRequest();
        if(request.makeRequest(this.openWeatherURL)) {
            request.writeResponseToFile(pathname);
        }
        else{
            System.out.println("WeatherStream.makeRequest: Request didn't respond for city - '" + city + "'!");
        }
    }

    public WeatherData requestWeatherData(String city) {
        WeatherData weatherData = new WeatherData();
        this.openWeatherURL = this.openWeatherURL.concat("&q=" + city);
        HttpRequest request = new HttpRequest();
        if(request.makeRequest(this.openWeatherURL)) {
            byte[] response = request.getResponse();
            JSONParser jsonParser = new JSONParser();
            try {
                JSONObject data = (JSONObject) jsonParser.parse(new String(response));
                JSONObject weather =(JSONObject)((JSONArray) data.get("weather")).get(0);
                JSONObject description = (JSONObject) data.get("main");
                weatherData.city = city;
                weatherData.type = weather.get("main").toString();
                weatherData.description = weather.get("description").toString();
                weatherData.temperature = description.get("temp").toString();
                return weatherData;
            }
            catch (ParseException ex){
                ex.printStackTrace();
            }
        }
        else{
            System.out.println("WeatherStream.makeRequest: Request didn't respond for city - '" + city + "'!");
        }
        return weatherData;
    }

    private String unitsFormToString(UnitsForm unitsForm) {
        switch (unitsForm){
            case metric:
                return "metric";
            case imperial:
                return "imperial";
            case standard:
                return "standard";
        }
        return "standard";
    }

}
