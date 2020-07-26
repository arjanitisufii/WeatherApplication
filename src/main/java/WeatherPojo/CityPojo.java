package WeatherPojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CityPojo {
    private List<WeatherPojo> weather;
    @JsonProperty ("main")
    private InfoPojo infoPojo;
    private WindPojo wind;
    private CloudsPojo clouds;
    private SysPojo sys;
    @JsonProperty ("name")
    private String name;

    public CityPojo(List<WeatherPojo> weather, InfoPojo infoPojo, WindPojo wind, CloudsPojo clouds, SysPojo sys, String name) {
        this.weather = weather;
        this.infoPojo = infoPojo;
        this.wind = wind;
        this.clouds = clouds;
        this.sys = sys;
        this.name = name;
    }

    public CityPojo() {}

    public List<WeatherPojo> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherPojo> weather) {
        this.weather = weather;
    }

    public InfoPojo getInfoPojo() {
        return infoPojo;
    }

    public void setInfoPojo(InfoPojo infoPojo) {
        this.infoPojo = infoPojo;
    }

    public WindPojo getWind() {
        return wind;
    }

    public void setWind(WindPojo wind) {
        this.wind = wind;
    }

    public CloudsPojo getClouds() {
        return clouds;
    }

    public void setClouds(CloudsPojo clouds) {
        this.clouds = clouds;
    }

    public SysPojo getSys() {
        return sys;
    }

    public void setSys(SysPojo sys) {
        this.sys = sys;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
