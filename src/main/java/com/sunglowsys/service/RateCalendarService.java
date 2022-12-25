package com.sunglowsys.service;

import com.sunglowsys.domain.RateCalendar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;

public interface RateCalendarService {
    RateCalendar save(RateCalendar rateCalendar);
    RateCalendar update(RateCalendar rateCalendar);
    List<RateCalendar> saveAll(List<RateCalendar> rateCalendars);
    Page<RateCalendar> getAll(Pageable pageable);
    Optional<RateCalendar> getOne(Long id);
    void delete(Long id);
}
