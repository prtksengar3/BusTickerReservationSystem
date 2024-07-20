package com.example.demo.Service.Abstraction;

import com.example.demo.Request.MakeReservationRequest;
import com.example.demo.Response.MakeReservationResponse;

public interface MakeReservationService {

    MakeReservationResponse makeReservation(MakeReservationRequest makeReservationRequest);
}
