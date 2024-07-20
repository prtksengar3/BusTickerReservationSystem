package com.example.demo.Repository;

import com.example.demo.Dto.BusScheduleDto;
import com.example.demo.Model.Routes;
import com.example.demo.Model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface RoutesRepository extends CrudRepository<Routes, Integer> {

    @Query(value = "select new com.example.demo.Dto.BusScheduleDto(b.busNumber,r.departureCity,r.arrivalCity,r.departureTime ," +
            "r.arrivalTime,r.date) from Routes r left join Buses b on r.busId = b.busId" +
            " where (:departureCity = 'abort' or r.departureCity like :departureCity) and  " +
            "(:arrivalCity = 'abort' or r.arrivalCity like :arrivalCity) and (:date is null or r.date = :date)")
    List<BusScheduleDto> getBusRoutes(String departureCity, String arrivalCity, LocalDate date);

}
