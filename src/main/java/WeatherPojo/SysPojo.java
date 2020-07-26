package WeatherPojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SysPojo {
    @JsonProperty ("country")
    private String country;

    public SysPojo(){}

    public SysPojo(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
