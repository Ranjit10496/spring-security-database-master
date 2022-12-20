package com.sunglowsys.service.impl;

import com.sunglowsys.domain.HotelBooking;
import com.sunglowsys.repository.HotelBookingRepository;
import com.sunglowsys.service.HotelBookingService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class HotelBookingServiceImpl implements HotelBookingService {
    private final HotelBookingRepository hotelBookingRepository;

    public HotelBookingServiceImpl(HotelBookingRepository hotelBookingRepository) {
        this.hotelBookingRepository = hotelBookingRepository;
    }

    @Override
    public HotelBooking save(HotelBooking hotelBooking) {
        hotelBooking.setBookingDate(LocalDate.now());
        hotelBooking.setTotalGuest(hotelBooking.getNoOfAdult() + hotelBooking.getNoOfChild());
        return hotelBookingRepository.save(hotelBooking);
    }

    @Override
    public HotelBooking update(HotelBooking hotelBooking) {
        return hotelBookingRepository.save(hotelBooking);
    }

    @Override
    public List<HotelBooking> getAll() {
        return hotelBookingRepository.findAll();
    }

    @Override
    public Optional<HotelBooking> getOne(Long id) {
        return hotelBookingRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        hotelBookingRepository.deleteById(id);
    }
}
