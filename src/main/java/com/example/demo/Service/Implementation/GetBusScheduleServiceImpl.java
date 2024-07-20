package com.example.demo.Service.Implementation;

import com.example.demo.Dto.BusScheduleDto;
import com.example.demo.Repository.RoutesRepository;
import com.example.demo.Request.GetBusScheduleRequest;
import com.example.demo.Response.GetBusScheduleResponse;
import com.example.demo.Service.Abstraction.GetBusScheduleService;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class GetBusScheduleServiceImpl implements GetBusScheduleService {

    @Autowired
    private RoutesRepository routesRepository;

    @Override
    public GetBusScheduleResponse getBusSchedule(GetBusScheduleRequest getBusScheduleRequest) {
        if(!validateRequest(getBusScheduleRequest)){ // validating request
            return new GetBusScheduleResponse("Invalid request",0);
        }

        String departureCity = StringUtils.isNotBlank(getBusScheduleRequest.getDepartureCity())?
                getBusScheduleRequest.getDepartureCity() : "abort";
        String arrivalCity = StringUtils.isNotBlank(getBusScheduleRequest.getArrivalCity())?
                getBusScheduleRequest.getArrivalCity() : "abort";
        LocalDate date = StringUtils.isNotBlank(getBusScheduleRequest.getDate())?
                LocalDate.parse(getBusScheduleRequest.getDate()) : null;

        // query to get route list with optional parameters
        List<BusScheduleDto> routesList = routesRepository.getBusRoutes(departureCity,arrivalCity,date);
        if(routesList.isEmpty()){
            return new GetBusScheduleResponse("No Route found",0);
        }

        return new GetBusScheduleResponse("success",1,
                routesList);
    }

    private boolean validateRequest(GetBusScheduleRequest getBusScheduleRequest) {
        if(StringUtils.isBlank(getBusScheduleRequest.getDepartureCity()) &&
                StringUtils.isBlank(getBusScheduleRequest.getDepartureCity()) &&
                Objects.isNull(getBusScheduleRequest.getDate())){
            return false;
        }
        return true;
    }
}
