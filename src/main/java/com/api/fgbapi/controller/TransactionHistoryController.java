package com.api.fgbapi.controller;

import com.api.fgbapi.misc.ProjectStatus;
import com.api.fgbapi.model.TopUpHistory;
import com.api.fgbapi.model.TransactionHistory;
import com.api.fgbapi.service.TopUpHistoryService;
import com.api.fgbapi.service.TransactionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "transaction/history", method=RequestMethod.GET)
public class TransactionHistoryController {

    @Autowired
    TransactionHistoryService transactionHistoryService;

    public List<TransactionHistory> getAll(){
        return transactionHistoryService.findAll();
    }

    @PutMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    ResponseEntity<ProjectStatus> saveTopUpHistory(@Valid @RequestBody TransactionHistory history){
        String uniqueID = UUID.randomUUID().toString();
        history.setId(uniqueID);
        transactionHistoryService.save(history);
        return new ResponseEntity<ProjectStatus>(new ProjectStatus("Success..."), HttpStatus.OK);
    }

    @GetMapping(value = "/details/{id}")
    public Optional<TransactionHistory> getById(@PathVariable(value = "id") String id){
        return transactionHistoryService.findById(id);
    }

    @PostMapping(value = "/delete/{id}")
    public void delete(@PathVariable(value = "id") TransactionHistory history){
        history.setStatus("Delete");
        transactionHistoryService.save(history);
    }
}
