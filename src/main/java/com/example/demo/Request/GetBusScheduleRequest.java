package com.example.demo.Request;

import com.example.demo.utils.ValidDate;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class GetBusScheduleRequest {

    @JsonProperty(value = "departure_city")
    private String departureCity;

    @JsonProperty(value = "arrival_city")
    private String arrivalCity;

    @JsonProperty(value = "date")
    @ValidDate
    private String date;

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
