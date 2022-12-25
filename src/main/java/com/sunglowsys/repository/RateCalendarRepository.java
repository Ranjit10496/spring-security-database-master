package com.sunglowsys.repository;

import com.sunglowsys.domain.RateCalendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateCalendarRepository extends JpaRepository<RateCalendar, Long> {
}
