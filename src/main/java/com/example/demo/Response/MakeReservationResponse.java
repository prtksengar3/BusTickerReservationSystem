package com.example.demo.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MakeReservationResponse {

    @JsonProperty(value = "reservation_id")
    private Integer reservationId;

    @JsonProperty(value = "message")
    private String message;

    @JsonProperty(value = "response_code")
    private Integer responseCode;

    public MakeReservationResponse(Integer reservationId, String message, Integer responseCode) {
        this.reservationId = reservationId;
        this.message = message;
        this.responseCode = responseCode;
    }

    public MakeReservationResponse(String message, Integer responseCode) {
        this.message = message;
        this.responseCode = responseCode;
    }
}
