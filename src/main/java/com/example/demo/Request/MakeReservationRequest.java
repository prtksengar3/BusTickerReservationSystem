package com.example.demo.Request;

import com.example.demo.utils.ValidDate;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MakeReservationRequest {

    @JsonProperty(value = "bus_id")
    private Integer busId;

    @JsonProperty(value = "seats")
    private Integer seats;

    @JsonProperty(value = "user_id")
    private Integer userId;

    @JsonProperty(value = "payment_via")
    private String paymentVia;

    public Integer getBusId() {
        return busId;
    }

    public void setBusId(Integer busId) {
        this.busId = busId;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPaymentVia() {
        return paymentVia;
    }

    public void setPaymentVia(String paymentVia) {
        this.paymentVia = paymentVia;
    }
}
