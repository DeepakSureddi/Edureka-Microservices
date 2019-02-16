package com.hotel.apil.edureka.project.hotelms.resources;

import com.hotel.apil.edureka.project.hotelms.model.Hotel;
import com.hotel.apil.edureka.project.hotelms.service.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.net.URI;
import java.util.List;

@Component
@RestController
public class HotelResources {
    private static final Logger logger = LoggerFactory.getLogger(HotelResources.class);

    @Autowired
    private HotelService hotelService;

    @PostMapping("/add")
    public ResponseEntity addHotel(@RequestBody Hotel hotel){
        logger.info("Hotel added {}", hotel);
        hotelService.createHotel(hotel);
        return ResponseEntity.created(URI.create("")).build();
    }

    @GetMapping("/retrieve")
    public List<Hotel> getAllHotels(){
        logger.info("Get all hotels in the list");
        return hotelService.getAllHotels();
    }
}
