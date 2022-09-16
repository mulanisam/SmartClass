package com.app.service;

import com.app.dto.TimeTableEnt;
import com.app.dto.TimeTableRequest;
import com.app.pojos.Period;

import java.util.List;

public interface ITimeTableService {
    List<Period> getTimeTable(TimeTableRequest request);
}
