package ui;

import WeatherPojo.CityPojo;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Controller {
    @FXML
    private TextField textField;
    @FXML
    private Label temp;
    @FXML
    private Label minTemp;
    @FXML
    private Label maxTemp;
    @FXML
    private Label weatherDescription;
    @FXML
    private Label windSpeed;
    @FXML
    private Label country;
    @FXML
    private Label cityLabel;
    @FXML
    private Label textFieldEmpty;
    @FXML
    private ImageView imageView;


    private static final String PRE_API_URL = "https://api.openweathermap.org/data/2.5/weather?q=";
    private static final String POST_API_URL = "&units=metric&appid=API_KEY&lang=al";

    @FXML
    public void getDataForCity() {
        textField.setOnKeyPressed(ke -> {
            if (ke.getCode().equals(KeyCode.ENTER))
            {
                String cityName = textField.getText();
                if(cityName == null || cityName.trim().length() == 0) {
                    textFieldEmpty.setText("Please fill textfield with a city name");
                    textFieldEmpty.setVisible(true);
                    setVisibility(false);
                    imageView.setImage(new Image("icon.png"));
                    return;
                }
                textFieldEmpty.setVisible(false);
                String city  = cityName.replaceAll(" ","+");
                String api_path = PRE_API_URL + city + POST_API_URL;
                try {
                    CityPojo cityPojo = initialize(api_path);
                    setVisibility(true);
                    weatherDescription.setText(cityPojo.getWeather().get(0).getDescription());
                    temp.setText("" + cityPojo.getInfoPojo().getTemp() + "°C");
                    minTemp.setText("" + cityPojo.getInfoPojo().getTempMin() + "°C");
                    maxTemp.setText("" + cityPojo.getInfoPojo().getTempMax() + "°C");
                    windSpeed.setText("" + cityPojo.getWind().getSpeed());
                    country.setText(cityPojo.getSys().getCountry());
                    cityLabel.setText(cityPojo.getName());
                    imageView.setImage(new Image("http://openweathermap.org/img/w/" + cityPojo.getWeather().get(0).getIcon() + ".png"));
                } catch (IllegalArgumentException | NullPointerException | IOException | InterruptedException nullPointerException) {
                    setVisibility(false);
                    textFieldEmpty.setVisible(true);
                    textFieldEmpty.setText("City not found");
                    imageView.setImage(new Image("icon.png"));
                }
            }
        });
    }

    private CityPojo initialize(String api_path) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(api_path))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(response.body(), CityPojo.class);
    }

    private void setVisibility(boolean value) {
        weatherDescription.setVisible(value);
        temp.setVisible(value);
        minTemp.setVisible(value);
        maxTemp.setVisible(value);
        windSpeed.setVisible(value);
        country.setVisible(value);
        cityLabel.setVisible(value);
    }
}
