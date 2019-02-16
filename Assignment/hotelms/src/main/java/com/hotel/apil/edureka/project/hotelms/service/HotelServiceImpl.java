package com.hotel.apil.edureka.project.hotelms.service;

import com.hotel.apil.edureka.project.hotelms.model.Hotel;
import com.hotel.apil.edureka.project.hotelms.repository.HotelRepository;
import com.hotel.apil.edureka.project.hotelms.resources.HotelResources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {
    private static final Logger logger = LoggerFactory.getLogger(HotelResources.class);

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public List<Hotel> getAllHotels() {
        logger.info("hotel service for get all hotels called.");
        return hotelRepository.findAll();
    }

    @Override
    public Hotel createHotel(Hotel hotel) {
        logger.info("add new hotel called");
        return hotelRepository.save(hotel);
    }
}
