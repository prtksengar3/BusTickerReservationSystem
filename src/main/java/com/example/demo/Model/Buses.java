package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
@Table(name = "buses")
public class Buses {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @JsonProperty(value = "bus_id")
    private Integer busId;

    @Getter
    @JsonProperty(value = "bus_number")
    private String busNumber;

    @Getter
    @JsonProperty(value = "total_seats")
    private Integer totalSeats;

    public Integer getBusId() {
        return busId;
    }

    public void setBusId(Integer busId) {
        this.busId = busId;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public Integer getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(Integer totalSeats) {
        this.totalSeats = totalSeats;
    }
}
