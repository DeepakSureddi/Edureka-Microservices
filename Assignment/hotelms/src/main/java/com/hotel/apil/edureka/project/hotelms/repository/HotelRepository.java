package com.hotel.apil.edureka.project.hotelms.repository;

import com.hotel.apil.edureka.project.hotelms.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface HotelRepository extends JpaRepository <Hotel , Integer> {
}
