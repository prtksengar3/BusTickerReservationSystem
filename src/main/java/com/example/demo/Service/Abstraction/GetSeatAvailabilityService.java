package com.example.demo.Service.Abstraction;

import com.example.demo.Request.GetBusScheduleRequest;
import com.example.demo.Response.GetBusScheduleResponse;
import com.example.demo.Response.GetSeatAvailabilityResponse;

public interface GetSeatAvailabilityService {

    GetSeatAvailabilityResponse getSeatAvailability(Integer busId);
}
