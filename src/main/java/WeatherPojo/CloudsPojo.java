package WeatherPojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CloudsPojo {
    @JsonProperty ("all")
    private double all;

    public CloudsPojo(){}

    public CloudsPojo(double all) {
        this.all = all;
    }

    public double getAll() {
        return all;
    }

    public void setAll(double all) {
        this.all = all;
    }
}
