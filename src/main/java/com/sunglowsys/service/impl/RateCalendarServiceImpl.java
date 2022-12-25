package com.sunglowsys.service.impl;

import com.sunglowsys.domain.RateCalendar;
import com.sunglowsys.repository.RateCalendarRepository;
import com.sunglowsys.service.RateCalendarService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RateCalendarServiceImpl implements RateCalendarService {
    private final RateCalendarRepository rateCalendarRepository;

    public RateCalendarServiceImpl(RateCalendarRepository rateCalendarRepository) {
        this.rateCalendarRepository = rateCalendarRepository;
    }

    @Override
    public RateCalendar save(RateCalendar rateCalendar) {
        return rateCalendarRepository.save(rateCalendar);
    }

    @Override
    public RateCalendar update(RateCalendar rateCalendar) {
        return rateCalendarRepository.save(rateCalendar);
    }

    @Override
    public List<RateCalendar> saveAll(List<RateCalendar> rateCalendars) {
        return rateCalendarRepository.saveAll(rateCalendars);
    }

    @Override
    public Page<RateCalendar> getAll(Pageable pageable) {
        return rateCalendarRepository.findAll(pageable);
    }

    @Override
    public Optional<RateCalendar> getOne(Long id) {
        return rateCalendarRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        rateCalendarRepository.deleteById(id);
    }
}