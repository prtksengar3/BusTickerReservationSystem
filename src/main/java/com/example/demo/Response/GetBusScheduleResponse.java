package com.example.demo.Response;

import com.example.demo.Dto.BusScheduleDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetBusScheduleResponse {

    @JsonProperty(value = "message")
    private String message;

    @JsonProperty(value = "response_code")
    private Integer responseCode;

    @JsonProperty(value = "bus_list")
    private List<BusScheduleDto> busesList;

    public GetBusScheduleResponse(String message, Integer responseCode, List<BusScheduleDto> busesList) {
        this.message = message;
        this.responseCode = responseCode;
        this.busesList = busesList;
    }

    public GetBusScheduleResponse(String message, Integer responseCode) {
        this.message = message;
        this.responseCode = responseCode;
    }

    public GetBusScheduleResponse() {
    }
}
