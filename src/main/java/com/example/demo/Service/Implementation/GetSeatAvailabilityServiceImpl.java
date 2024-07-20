package com.example.demo.Service.Implementation;

import com.example.demo.Dto.BusScheduleDto;
import com.example.demo.Model.Buses;
import com.example.demo.Repository.BusesRepository;
import com.example.demo.Repository.ReservationsRepository;
import com.example.demo.Repository.RoutesRepository;
import com.example.demo.Request.GetBusScheduleRequest;
import com.example.demo.Response.GetBusScheduleResponse;
import com.example.demo.Response.GetSeatAvailabilityResponse;
import com.example.demo.Service.Abstraction.GetBusScheduleService;
import com.example.demo.Service.Abstraction.GetSeatAvailabilityService;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class GetSeatAvailabilityServiceImpl implements GetSeatAvailabilityService {

    @Autowired
    private ReservationsRepository reservationsRepository;

    @Autowired
    private BusesRepository busesRepository;

    @Override
    public GetSeatAvailabilityResponse getSeatAvailability(Integer busId) {
        if(Objects.isNull(busId)){
            return new GetSeatAvailabilityResponse("Invalid request",0);
        }
        // query to get sum of occupied seats
        Integer occupiedSeats = reservationsRepository.getRemainingSeats(busId);

        //query to find total seats in a bus
        Optional<Buses> busData = busesRepository.findById(busId);
        if(busData.isPresent()){
            int remainingSeats = busData.get().getTotalSeats() - occupiedSeats;
            return new GetSeatAvailabilityResponse(remainingSeats,"success",1);
        }
        else{
            return new GetSeatAvailabilityResponse("Invalid bus id",0);
        }

    }
}
