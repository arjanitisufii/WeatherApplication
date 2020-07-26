package WeatherPojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InfoPojo {
    @JsonProperty ("temp")
    private double temp;
    @JsonProperty ("feels_like")
    private double feelsLike;
    @JsonProperty ("temp_min")
    private double tempMin;
    @JsonProperty ("temp_max")
    private double tempMax;


    public InfoPojo(){}

    public InfoPojo(double temp, double feelsLike, double tempMin, double tempMax) {
        this.temp = temp;
        this.feelsLike = feelsLike;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(double feelsLike) {
        this.feelsLike = feelsLike;
    }

    public double getTempMin() {
        return tempMin;
    }

    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    public double getTempMax() {
        return tempMax;
    }

    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }
}
