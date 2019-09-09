public class WeatherStream {

    enum UnitsForm{
        standard,
        metric,
        imperial
    }

    private String apiKey;
    private UnitsForm unitsForm;

    public WeatherStream(String apiKey, UnitsForm unitForm)
    {
        this.apiKey = apiKey;
        this.unitsForm = unitForm;
    }

    public void makeRequest(String city)
    {
        String openWeatherURL = "https://api.openweathermap.org/data/2.5/weather?";
        openWeatherURL = openWeatherURL.concat("q=" + city);
        openWeatherURL = openWeatherURL.concat("&APPID=" + this.apiKey);
        openWeatherURL = openWeatherURL.concat("&units=" + this.unitsFormToString(this.unitsForm));
        HttpRequest request = new HttpRequest();
        if(request.makeRequest(openWeatherURL)) {
            request.writeResponseToFile("output.txt");
        }
        else{
            System.out.println("WeatherStream.makeRequest: Request didn't respond for city - '" + city + "'!");
        }
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
