package com.example.demo.Service.Implementation;

import com.example.demo.Model.Buses;
import com.example.demo.Model.Reservations;
import com.example.demo.Model.User;
import com.example.demo.Repository.BusesRepository;
import com.example.demo.Repository.ReservationsRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Request.MakeReservationRequest;
import com.example.demo.Response.MakeReservationResponse;
import com.example.demo.Service.Abstraction.MakeReservationService;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class MakeReservationServiceImpl implements MakeReservationService {

    @Autowired
    private ReservationsRepository reservationsRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BusesRepository busesRepository;
    Integer totalBusSeats;
    @Override
    public MakeReservationResponse makeReservation(MakeReservationRequest makeReservationRequest) {
        Integer busId = makeReservationRequest.getBusId();
        Integer userId = makeReservationRequest.getUserId();
        Integer seats = makeReservationRequest.getSeats();
        String paymentVia = makeReservationRequest.getPaymentVia(); //validating request
        if(!validateRequest(busId,userId,seats,paymentVia)){
            return new MakeReservationResponse("Invalid Request",0);
        }

        Integer occupiedSeats = reservationsRepository.getRemainingSeats(busId);
        int remainingSeats = totalBusSeats - occupiedSeats;

        // checking empty seats before reservation
        if(!(remainingSeats >=seats)){  // checking remaining seats
            return new MakeReservationResponse("No seats left",0);
        }
        Reservations reservations = new Reservations();
        reservations.setBusId(busId);
        reservations.setUserId(userId);
        reservations.setSeats(seats);
        reservations.setPaymentVia(paymentVia);
        reservations.setStatus(1);
        Reservations successReservation = reservationsRepository.save(reservations); // saving in reservations table
        return new MakeReservationResponse(successReservation.getReservationId(),"success",1);
    }

    private boolean validateRequest(Integer busId, Integer userId, Integer seats, String paymentVia) {
        if(seats<1 || StringUtils.isBlank(paymentVia)) return false;
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty()) return false;
        Optional<Buses> bus = busesRepository.findById(busId);
        bus.ifPresent(buses -> totalBusSeats = buses.getTotalSeats());
        return bus.isPresent();
    }

}
