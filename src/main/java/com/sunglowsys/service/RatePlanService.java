package com.sunglowsys.service;

import com.sunglowsys.domain.RatePlan;
import com.sunglowsys.dto.RatePlanDto;

import java.util.List;
import java.util.Optional;

public interface RatePlanService {
    RatePlan save(RatePlan ratePlan);
//    List<RatePlan> saveAll();
    RatePlan update(RatePlan ratePlan);
    List<RatePlan> getAll();
    Optional<RatePlan> getOne(Long id);
    void delete(Long id);
}
