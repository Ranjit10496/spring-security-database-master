package com.sunglowsys.repository;

import com.sunglowsys.domain.InventoryCalendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryCalendarRepository extends JpaRepository<InventoryCalendar, Long> {
}
