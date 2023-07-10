package com.example.workindia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.workindia.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>{

	Booking findByBookingId(Long bookingId);

}
