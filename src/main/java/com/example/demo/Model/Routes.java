package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Data
@Table(name = "routes")
public class Routes {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @JsonProperty(value = "route_id")
    private Integer routeId;

    @Getter
    @JsonProperty(value = "bus_id")
    private Integer busId;

    @Getter
    @JsonProperty(value = "departure_city")
    private String departureCity;
    @Getter
    @JsonProperty(value = "arrival_city")
    private String arrivalCity;
    @Getter
    @JsonProperty(value = "departure_time")
    private LocalTime departureTime;
    @Getter
    @JsonProperty(value = "arrival_time")
    private LocalTime arrivalTime;

    @Getter
    @JsonProperty(value = "date")
    private LocalDate date;

    public Integer getBusId() {
        return busId;
    }

    public void setBusId(Integer busId) {
        this.busId = busId;
    }

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

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
