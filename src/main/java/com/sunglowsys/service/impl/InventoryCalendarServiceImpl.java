package com.sunglowsys.service.impl;

import com.sunglowsys.domain.InventoryCalendar;
import com.sunglowsys.repository.InventoryCalendarRepository;
import com.sunglowsys.service.InventoryCalendarService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class InventoryCalendarServiceImpl implements InventoryCalendarService {
    private final InventoryCalendarRepository inventoryCalendarRepository;

    public InventoryCalendarServiceImpl(InventoryCalendarRepository inventoryCalendarRepository) {
        this.inventoryCalendarRepository = inventoryCalendarRepository;
    }

    @Override
    public InventoryCalendar save(InventoryCalendar inventoryCalender) {
        return inventoryCalendarRepository.save(inventoryCalender);
    }

    @Override
    public List<InventoryCalendar> saveAll(List<InventoryCalendar> calenders) {
        return inventoryCalendarRepository.saveAll(calenders);
    }

    @Override
    public InventoryCalendar update(InventoryCalendar inventoryCalender) {
        return inventoryCalendarRepository.save(inventoryCalender);
    }

    @Override
    public List<InventoryCalendar> findAll() {
        return inventoryCalendarRepository.findAll();
    }

    @Override
    public Optional<InventoryCalendar> findById(Long id) {
        return inventoryCalendarRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        inventoryCalendarRepository.deleteById(id);
    }
}
