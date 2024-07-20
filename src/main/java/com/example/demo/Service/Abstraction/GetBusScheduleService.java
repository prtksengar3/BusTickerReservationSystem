package com.example.demo.Service.Abstraction;

import com.example.demo.Request.GetBusScheduleRequest;
import com.example.demo.Request.LoginRequest;
import com.example.demo.Response.GetBusScheduleResponse;
import com.example.demo.Response.LoginResponse;

public interface GetBusScheduleService {

    GetBusScheduleResponse getBusSchedule(GetBusScheduleRequest getBusScheduleRequest);
}
