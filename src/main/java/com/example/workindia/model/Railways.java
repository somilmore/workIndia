package com.example.workindia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="railways")
public class Railways {
	
	@Id
	@Column(name="id")
	private long id;
	
	@Column(name="train_name")
	private String trainName;
	
	@Column(name="source")
	private String source;
	
	@Column(name="destination")
	private String destination;
	
	@Column(name="seat_capacity")
	private int seatCapacity;
	
	@Column(name="arrival_time_at_source")
	private String arrivalTimeAtSource;
	
	@Column(name="arrival_time_at_destination")
	private String arrivalTimeAtDestination;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
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

	public Railways() {
		super();
	}

	public Railways(long id, String trainName, String source, String destination, int seatCapacity,
			String arrivalTimeAtSource, String arrivalTimeAtDestination) {
		super();
		this.id = id;
		this.trainName = trainName;
		this.source = source;
		this.destination = destination;
		this.seatCapacity = seatCapacity;
		this.arrivalTimeAtSource = arrivalTimeAtSource;
		this.arrivalTimeAtDestination = arrivalTimeAtDestination;
	}

	@Override
	public String toString() {
		return "Railways [id=" + id + ", trainName=" + trainName + ", source=" + source + ", destination=" + destination
				+ ", seatCapacity=" + seatCapacity + ", arrivalTimeAtSource=" + arrivalTimeAtSource
				+ ", arrivalTimeAtDestination=" + arrivalTimeAtDestination + "]";
	}

	

	
	
}
