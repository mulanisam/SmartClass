package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TimeTableEnt {
    private String std;
    private String subName;
    private LocalTime startTime;
    private LocalTime endTime;
    private String teacherName;
}
