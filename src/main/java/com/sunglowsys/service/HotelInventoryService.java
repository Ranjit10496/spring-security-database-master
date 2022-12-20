package com.sunglowsys.service;

import com.sunglowsys.domain.HotelInventory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface HotelInventoryService {
    HotelInventory save(HotelInventory hotelInventory);
    HotelInventory update(HotelInventory hotelInventory);
    Page<HotelInventory> getAll(Pageable pageable);
    Optional<HotelInventory> getOne(Long id);
    void delete(Long id);
}
