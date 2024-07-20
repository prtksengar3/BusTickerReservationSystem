package com.example.demo.Controller;

import com.example.demo.Request.GetBusScheduleRequest;
import com.example.demo.Request.LoginRequest;
import com.example.demo.Request.MakeReservationRequest;
import com.example.demo.Response.GetBusScheduleResponse;
import com.example.demo.Response.GetSeatAvailabilityResponse;
import com.example.demo.Response.LoginResponse;
import com.example.demo.Response.MakeReservationResponse;
import com.example.demo.Service.Abstraction.GetBusScheduleService;
import com.example.demo.Service.Abstraction.GetSeatAvailabilityService;
import com.example.demo.Service.Abstraction.LoginService;
import com.example.demo.Service.Abstraction.MakeReservationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static com.example.demo.utils.Endpoints.*;

@Controller
@RestController
public class ApiController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private GetBusScheduleService getBusScheduleService;

    @Autowired
    private GetSeatAvailabilityService getSeatAvailabilityService;

    @Autowired
    private MakeReservationService makeReservationService;

    @PostMapping(value = LOGIN)
    public LoginResponse login(@RequestBody LoginRequest loginRequest){
        return loginService.login(loginRequest);
    }

    @PostMapping(value = GET_BUS_SCHEDULE)
    public GetBusScheduleResponse getBusSchedule(@RequestBody @Valid GetBusScheduleRequest getBusScheduleRequest){
        return getBusScheduleService.getBusSchedule(getBusScheduleRequest);
    }

    @GetMapping(value = GET_AVAILABLE_SEATS)
    public GetSeatAvailabilityResponse getAvailableSeats(@RequestParam Integer busId){
        return getSeatAvailabilityService.getSeatAvailability(busId);
    }

    @PostMapping(value = MAKE_RESERVATION)
    public MakeReservationResponse makeReservation(@RequestBody MakeReservationRequest makeReservationRequest){
        return makeReservationService.makeReservation(makeReservationRequest);
    }
}
