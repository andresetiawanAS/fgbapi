package com.api.fgbapi.controller;

import com.api.fgbapi.model.Balance;
import com.api.fgbapi.model.TopUpHistory;
import com.api.fgbapi.service.BalanceService;
import com.api.fgbapi.service.TopUpHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(path = "/history", method = GET)
public class TopUpHistoryController {

    @Autowired
    TopUpHistoryService topUpHistoryService;

    @GetMapping(value = "/topup")
    public List<TopUpHistory> getAll() {
        return topUpHistoryService.findAll();
    }
}
