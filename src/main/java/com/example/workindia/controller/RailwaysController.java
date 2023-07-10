package com.example.workindia.controller;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.*;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.workindia.model.Booking;
import com.example.workindia.model.Railways;
import com.example.workindia.repository.BookingRepository;
import com.example.workindia.repository.RailwaysRepository;

@RestController
@RequestMapping("/trains")
public class RailwaysController {
	
	RailwaysRepository repository;
	BookingRepository bookRepository;
	
	@PostMapping("/create")
	public String create(@RequestBody Railways railways) {
		
		
		Optional<Railways> entity = getRailways(railways.getId());
		
		JSONObject response=new JSONObject();
		 
		 if(entity.isPresent()) {
			 return "Record Already Exists";
		 }
		 else {
			 repository.save(railways);
			 response.put("message","Train added successfully");
			 response.put("train_id",railways.getId());
			 
			 return response.toString();
		 }
	}
	
	 public Optional<Railways> getRailways(@RequestParam Long id) {
	  Optional<Railways> entity =  repository.findById(id);
	  
	  return entity;
	 }
	
	@GetMapping("/availability")
	public String getseats(@RequestParam String source, @RequestParam String destination) {
		 List<Railways> list = repository.findBySourceAndDestination(source, destination);
		 
		 List<JSONObject> ans = new ArrayList<>();
		 
		 if(list==null) 
			 return "Train for soruce: "+source+" and destination: "+destination+" is not available";
		 
		 else {
			 for(int i=0;i<list.size();i++) {
				 Railways contain=list.get(i);
				 JSONObject response=new JSONObject();
				 
				 response.put("train_id", contain.getId());
				 response.put("train_name", contain.getTrainName());
				 response.put("available_seats", contain.getSeatCapacity());
				 
				 ans.add(response);
			 }
		 }
		 
		 return ans.toString();
		 
	}
	
	
	public static long generateUniqueLong() {
        UUID uuid = UUID.randomUUID();
        long uniqueLong = Math.abs(uuid.getMostSignificantBits());
        String uniqueString = String.valueOf(uniqueLong);
        int desiredLength = 10;
        if (uniqueString.length() > desiredLength) {
            uniqueString = uniqueString.substring(0, desiredLength);
        } else if (uniqueString.length() < desiredLength) {
            StringBuilder stringBuilder = new StringBuilder(uniqueString);
            while (stringBuilder.length() < desiredLength) {
                stringBuilder.insert(0, "0");
            }
            uniqueString = stringBuilder.toString();
        }
        return Long.parseLong(uniqueString);
	}
	
	  public static String generateUniqueListAsString(int length) {
	        Set<Integer> uniqueNumbers = new HashSet<>();
	        Random random = new Random();

	        while (uniqueNumbers.size() < length) {
	            int randomNumber = random.nextInt();
	            uniqueNumbers.add(randomNumber);
	        }

	        List<Integer> numberList = new ArrayList<>(uniqueNumbers);
	        return numberList.stream()
	                .map(String::valueOf)
	                .collect(Collectors.joining(", "));
	    }
	
	@PostMapping("/{trainId}/book")
	public String book(@PathVariable("trainId") Long trainId,@RequestBody Booking booking) {
		
		Railways railways = repository.findById(trainId).orElseThrow(() -> new RuntimeException("Train not found"));

		if(booking.getNo_of_seats() <= railways.getSeatCapacity()){
			
			railways.setSeatCapacity(railways.getSeatCapacity()-booking.getNo_of_seats());
			repository.save(railways);
			
			long bookingId=generateUniqueLong();
			String uniqueListAsString = generateUniqueListAsString(booking.getNo_of_seats());
			
			JSONObject response=new JSONObject();
			response.put("message","Seat Booked Successfully");
			response.put("booking_id", bookingId);
			response.put("seats_numbers", uniqueListAsString);
			
			Booking data=new Booking(bookingId, 
										trainId, 
										railways.getTrainName(), 
										booking.getUserId(), 
										booking.getNo_of_seats(),
										uniqueListAsString, 
										railways.getArrivalTimeAtSource(),
										railways.getArrivalTimeAtDestination());
			bookRepository.save(data);
			
			return response.toString();
			
		}
		
		else
			return "Seats not available";
	}
	
	@GetMapping("/bookings/{booking_id}")
	public String getDetails(@PathVariable("booking_id") Long bookingId) {
 Booking data = bookRepository.findByBookingId(bookingId);
		 
		 
		 if(data==null) 
			 return "Record Not Found";
		 
		 return data.toString();
	}
}
