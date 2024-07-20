package com.example.demo.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Data
@NoArgsConstructor
public class BusScheduleDto {

    @JsonProperty(value = "bus_number")
    private String busNumber;

    @JsonProperty(value = "departure_city")
    private String departureCity;
    @JsonProperty(value = "arrival_city")
    private String arrivalCity;
    @JsonProperty(value = "departure_time")
    private LocalTime departureTime;
    @JsonProperty(value = "arrival_time")
    private LocalTime arrivalTime;

    @JsonProperty(value = "date")
    private LocalDate date;

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
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

    public BusScheduleDto(String busNumber, String departureCity, String arrivalCity, LocalTime departureTime, LocalTime arrivalTime, LocalDate date) {
        this.busNumber = busNumber;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.date = date;
    }

    public BusScheduleDto() {
    }
}
