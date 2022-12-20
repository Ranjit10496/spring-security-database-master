package com.sunglowsys.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "hotel_inventory")
public class HotelInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_inventories")
    private Integer totalInventory;

    @ManyToOne
    private Hotel hotel;

    @ManyToOne
    private RoomType roomType;
}
