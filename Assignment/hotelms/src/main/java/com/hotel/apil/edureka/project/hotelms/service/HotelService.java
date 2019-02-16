package com.hotel.apil.edureka.project.hotelms.service;


import com.hotel.apil.edureka.project.hotelms.model.Hotel;
import java.util.List;

public interface HotelService {

    List<Hotel> getAllHotels();
    Hotel createHotel(Hotel hotel);

}
