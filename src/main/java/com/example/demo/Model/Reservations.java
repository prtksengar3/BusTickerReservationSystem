package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Data
@Table(name = "reservations")
public class Reservations {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @JsonProperty(value = "reservation_id")
    private Integer reservationId;

    @Getter
    @JsonProperty(value = "user_id")
    private Integer userId;

    @Getter
    @JsonProperty(value = "bus_id")
    private Integer busId;

    @JsonProperty(value = "seats")
    private Integer seats;

    @JsonProperty(value = "payment_via")
    private String paymentVia;

    @JsonProperty(value = "reservation_date")
    private LocalDateTime reservationDate;

    @JsonProperty(value = "status")
    private Integer status;

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

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

    public String getPaymentVia() {
        return paymentVia;
    }

    public void setPaymentVia(String paymentVia) {
        this.paymentVia = paymentVia;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
