package com.example.workindia.model;

import jakarta.persistence.*;

@Entity
@Table(name="booking_details")
public class Booking {
	
	@Id
	@Column(name="booking_id")
	private long bookingId;
	
	@Column(name="train_id")
	private long trainId;
	
	@Column(name="train_name")
	private String trainName;
	
	@Column(name="user_id")
	private long userId;
	
	@Column(name="no_of_seats")
	private int no_of_seats;
	
	@Column(name="seat_numbers")
	private String seatNumbers;
	
	@Column(name="arrival_time_at_source")
	private String arrivalTimeAtSource;
	
	@Column(name="arrival_time_at_destination")
	private String arrivalTimeAtDestination;

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public long getTrainId() {
		return trainId;
	}

	public void setTrainId(long trainId) {
		this.trainId = trainId;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getNo_of_seats() {
		return no_of_seats;
	}

	public void setNo_of_seats(int no_of_seats) {
		this.no_of_seats = no_of_seats;
	}

	public String getSeatNumbers() {
		return seatNumbers;
	}

	public void setSeatNumbers(String seatNumbers) {
		this.seatNumbers = seatNumbers;
	}

	public String getArrivalTimeAtSource() {
		return arrivalTimeAtSource;
	}

	public void setArrivalTimeAtSource(String arrivalTimeAtSource) {
		this.arrivalTimeAtSource = arrivalTimeAtSource;
	}

	public String getArrivalTimeAtDestination() {
		return arrivalTimeAtDestination;
	}

	public void setArrivalTimeAtDestination(String arrivalTimeAtDestination) {
		this.arrivalTimeAtDestination = arrivalTimeAtDestination;
	}

	public Booking() {
		super();
	}

	public Booking(long bookingId, long trainId, String trainName, long userId, int no_of_seats, String seatNumbers,
			String arrivalTimeAtSource, String arrivalTimeAtDestination) {
		super();
		this.bookingId = bookingId;
		this.trainId = trainId;
		this.trainName = trainName;
		this.userId = userId;
		this.no_of_seats = no_of_seats;
		this.seatNumbers = seatNumbers;
		this.arrivalTimeAtSource = arrivalTimeAtSource;
		this.arrivalTimeAtDestination = arrivalTimeAtDestination;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", trainId=" + trainId + ", trainName=" + trainName + ", userId="
				+ userId + ", no_of_seats=" + no_of_seats + ", seatNumbers=" + seatNumbers + ", arrivalTimeAtSource="
				+ arrivalTimeAtSource + ", arrivalTimeAtDestination=" + arrivalTimeAtDestination + "]";
	}
	
	
	
}
