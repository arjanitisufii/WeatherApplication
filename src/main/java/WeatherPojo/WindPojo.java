package WeatherPojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WindPojo {
    @JsonProperty ("speed")
    private double speed;

    public WindPojo(){}

    public WindPojo(double speed) {
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
