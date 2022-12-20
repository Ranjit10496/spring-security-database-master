package com.sunglowsys.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "inventory_calendar")
public class InventoryCalendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate inventoryDate;
    
    @Column(name = "available")
    private Integer available;

    private Integer sold;
    private Integer block;

    @ManyToOne(optional = false)
    private Hotel hotel;
    @ManyToOne(optional = false)
    private RoomType roomType;

    public InventoryCalendar(LocalDate inventoryDate, Integer available, Integer sold, Integer block, Hotel hotel, RoomType roomType) {
        this.inventoryDate = inventoryDate;
        this.available = available;
        this.sold = sold;
        this.block = block;
        this.hotel = hotel;
        this.roomType = roomType;
    }
}
