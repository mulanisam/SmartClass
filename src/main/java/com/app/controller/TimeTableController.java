package com.app.controller;

import com.app.dto.TimeTableRequest;
import com.app.service.ITimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/timeTable")
public class TimeTableController {

    @Autowired
    private ITimeTableService service;

    @PostMapping("/get")
    public ResponseEntity<?> getTimeTable(@Valid @RequestBody TimeTableRequest request)
    {
        System.out.println("Hello"+request.getStd()+request.getDate());
        return ResponseEntity.ok(service.getTimeTable(request));
    }

}
