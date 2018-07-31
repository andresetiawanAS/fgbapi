package com.api.fgbapi.controller;

import com.api.fgbapi.misc.ProjectStatus;
import com.api.fgbapi.model.Balance;
import com.api.fgbapi.model.TopUpHistory;
import com.api.fgbapi.service.BalanceService;
import com.api.fgbapi.service.TopUpHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import javax.validation.Valid;
import java.awt.*;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/history", method=RequestMethod.GET)
public class TopUpHistoryController implements Serializable {

    @Autowired
    TopUpHistoryService topUpHistoryService;

    @Autowired
    BalanceService balanceService;

    @GetMapping(value = "/all")
    @CrossOrigin(origins = "*")
    public List<TopUpHistory> getAll(){
        return topUpHistoryService.findAll();
    }

    @PutMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @CrossOrigin(origins = "*")
    public @ResponseBody
    ResponseEntity<ProjectStatus> saveTopUpHistory(@Valid @RequestBody TopUpHistory history){
        String uniqueID = UUID.randomUUID().toString();
        history.setId(uniqueID);
        String id = history.getBalance_id();
        Optional<Balance> balance = balanceService.findById(id);
        if(id.equals(balance.get().getId())){
            Double topUpValue = history.getTopup_value();
            topUpHistoryService.save(history);
            balanceService.updateBalanceById(id, topUpValue);
            return new ResponseEntity<ProjectStatus>(new ProjectStatus("Success"), HttpStatus.OK);
        }
        return null;
    }

    @GetMapping(value = "/details/{id}")
    @CrossOrigin(origins = "*")
    public Optional<TopUpHistory> getById(@PathVariable(value = "id") String id){
        return topUpHistoryService.findById(id);
    }

    @PostMapping(value = "/delete/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<ProjectStatus> delete(@PathVariable(value = "id") TopUpHistory history){
        history.setStatus("Inactive");
        topUpHistoryService.save(history);
        return new ResponseEntity<ProjectStatus>(new ProjectStatus("Success"), HttpStatus.OK);
    }
}
