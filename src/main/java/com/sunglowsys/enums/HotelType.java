package com.sunglowsys.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum HotelType {
    ONE_STAR("One star"),
    TWO_STAR("Two star"),
    THREE_STAR("Three star"),
    FIVE_STAR("Five star"),
    SEVEN_STAR("Seven star");
    private String name;


}
