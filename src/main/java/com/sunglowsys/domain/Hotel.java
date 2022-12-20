package com.sunglowsys.domain;

import com.sunglowsys.enums.HotelType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "code")
    @NotNull
    private String code;

    @Column(nullable = false, name = "name")
    @NotNull
    private String name;

    //    enum field
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "hotel_type")
    private HotelType hotelType;

    @Email
    @Column(unique = true, name = "email")
    private String email;

    @Column(nullable = false, name = "mobile")
    @NotNull
    private String mobile;
}
