package com.sunglowsys.service.impl;

import com.sunglowsys.domain.RateCalendar;
import com.sunglowsys.domain.RatePlan;
import com.sunglowsys.dto.RatePlanDto;
import com.sunglowsys.repository.RatePlanRepository;
import com.sunglowsys.service.RateCalendarService;
import com.sunglowsys.service.RatePlanService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class RatePlanServiceImpl implements RatePlanService {
    private final RatePlanRepository ratePlanRepository;
//    private final RateCalendarService rateCalendarService;

    public RatePlanServiceImpl(RatePlanRepository ratePlanRepository) {
        this.ratePlanRepository = ratePlanRepository;
//        this.rateCalendarService = rateCalendarService;
    }

    @Override
    public RatePlan save(RatePlan ratePlan) {
       return ratePlanRepository.save(ratePlan);
    }



    @Override
    public RatePlan update(RatePlan ratePlan) {
        return ratePlanRepository.save(ratePlan);
    }

    @Override
    public List<RatePlan> getAll() {
        return ratePlanRepository.findAll();
    }

    @Override
    public Optional<RatePlan> getOne(Long id) {
        return ratePlanRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        ratePlanRepository.deleteById(id);
    }

//    List<RateCalendar> generateRateCalendar(RatePlanDto ratePlanDto) {
//        List<RateCalendar> calendars = new ArrayList<>();
//        LocalDate date = LocalDate.now();
//        for (int i = 0; i<365; i++) {
//            calendars.add(new RateCalendar(date.plusDays(i), ratePlanDto.getSingleOccupancy(), ratePlanDto.getDoubleOccupancy(), ratePlanDto.getExtraAdultPrice(),
//                    ratePlanDto.getExtraChildPrice(), ratePlanDto.getApplicableDays(), ratePlanDto.getHotel(), ratePlanDto.getRatePlan()));
//        }
//        return calendars;
//    }
}
