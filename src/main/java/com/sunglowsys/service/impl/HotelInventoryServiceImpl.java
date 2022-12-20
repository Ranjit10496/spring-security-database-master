package com.sunglowsys.service.impl;

import com.sunglowsys.domain.HotelInventory;
import com.sunglowsys.domain.InventoryCalendar;
import com.sunglowsys.repository.HotelInventoryRepository;
import com.sunglowsys.service.HotelInventoryService;
import com.sunglowsys.service.InventoryCalendarService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class HotelInventoryServiceImpl implements HotelInventoryService {
    private final HotelInventoryRepository hotelInventoryRepository;
    private final InventoryCalendarService inventoryCalendarService;

    public HotelInventoryServiceImpl(HotelInventoryRepository hotelInventoryRepository, InventoryCalendarService inventoryCalendarService) {
        this.hotelInventoryRepository = hotelInventoryRepository;
        this.inventoryCalendarService = inventoryCalendarService;
    }

    @Override
    public HotelInventory save(HotelInventory hotelInventory) {
        HotelInventory result = hotelInventoryRepository.save(hotelInventory);
        inventoryCalendarService.saveAll(generateCalender(result));
        return result;
    }

    @Override
    public HotelInventory update(HotelInventory hotelInventory) {
        return hotelInventoryRepository.save(hotelInventory);
    }

    @Override
    public Page<HotelInventory> getAll(Pageable pageable) {
        return hotelInventoryRepository.findAll(pageable);
    }

    @Override
    public Optional<HotelInventory> getOne(Long id) {
        return hotelInventoryRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        hotelInventoryRepository.deleteById(id);
    }

    //    GenerateInventoryCalendar
    private List<InventoryCalendar> generateCalender(HotelInventory hotelInventory) {

        List<InventoryCalendar> calenders = new ArrayList<>();
        LocalDate date = LocalDate.now();
        for (int i = 0; i <= 365; i++) {
            calenders.add(new InventoryCalendar(date.plusDays(i), hotelInventory.getTotalInventory(),
                    0, 0, hotelInventory.getHotel(), hotelInventory.getRoomType()));
        }
        return calenders;
    }
//    public static void validateInventoryPOST(HotelInventory hotelInventory) {
//        validateName(hotelInventory.getHotel());
//        validateType(hotelInventory.getRoomType());
//        validateDates(hotelInventory.getAvailableFrom(), inventory.getAvailableTo());
//    }

}