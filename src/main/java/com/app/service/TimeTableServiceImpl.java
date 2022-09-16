package com.app.service;

import com.app.dao.ITimeTableDao;
import com.app.dto.TimeTableEnt;
import com.app.dto.TimeTableRequest;
import com.app.pojos.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimeTableServiceImpl implements ITimeTableService{
    @Autowired
    private ITimeTableDao dao;

    @Override
    public List<Period> getTimeTable(TimeTableRequest request) {
        ArrayList<Period> periods = new ArrayList<>();
        periods= (ArrayList<Period>) dao.getTimeTable(request.getStd(),request.getDate());
        for (Period p:periods) {
            System.out.println(p.toString());
        }
        return periods;
    }
}
