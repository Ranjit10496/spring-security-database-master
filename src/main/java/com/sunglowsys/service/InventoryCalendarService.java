package com.sunglowsys.service;

import com.sunglowsys.domain.InventoryCalendar;

import java.util.List;
import java.util.Optional;

public interface InventoryCalendarService {
    InventoryCalendar save(InventoryCalendar inventoryCalender);

    List<InventoryCalendar> saveAll(List<InventoryCalendar> calenders);

    InventoryCalendar update(InventoryCalendar inventoryCalender);

    List<InventoryCalendar> findAll();

    Optional<InventoryCalendar> findById(Long id);

    void delete(Long id);
}
