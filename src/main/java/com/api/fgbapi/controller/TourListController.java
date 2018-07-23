package com.api.fgbapi.controller;

import com.api.fgbapi.model.TourList;
import com.api.fgbapi.repository.TourListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(path="/tourlist", method = GET)
public class TourListController {
    @Autowired
    TourListRepository tourListRepository;

    @GetMapping("/show")
    public @ResponseBody
    List<TourList> TesterHello(){
        return tourListRepository.findAll();

    }
}
