package com.example.demo.Repository;

import com.example.demo.Model.Reservations;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReservationsRepository extends CrudRepository<Reservations, Integer> {

    @Query(value = "select sum(r.seats) from Reservations r where r.busId = :busId and r.status = 1")
    Integer getRemainingSeats(Integer busId);

}
