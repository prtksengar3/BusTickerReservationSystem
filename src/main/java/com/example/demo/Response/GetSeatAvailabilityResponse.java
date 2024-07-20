package com.example.demo.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GetSeatAvailabilityResponse {

    @JsonProperty(value = "seats")
    private Integer seats;

    @JsonProperty(value = "message")
    private String message;

    @JsonProperty(value = "response_code")
    private Integer responseCode;

    public GetSeatAvailabilityResponse(String message, Integer responseCode) {
        this.message = message;
        this.responseCode = responseCode;
    }

    public GetSeatAvailabilityResponse(Integer seats, String message, Integer responseCode) {
        this.seats = seats;
        this.message = message;
        this.responseCode = responseCode;
    }
}
