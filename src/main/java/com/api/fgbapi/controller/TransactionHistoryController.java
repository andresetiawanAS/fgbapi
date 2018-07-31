package com.api.fgbapi.controller;

import com.api.fgbapi.misc.ProjectStatus;
import com.api.fgbapi.model.Balance;
import com.api.fgbapi.model.TransactionHistory;
import com.api.fgbapi.service.BalanceService;
import com.api.fgbapi.service.TransactionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/transaction/history", method=RequestMethod.GET)
public class TransactionHistoryController {

    @Autowired
    TransactionHistoryService transactionHistoryService;
    @Autowired
    BalanceService balanceService;

    @GetMapping("/all")
    @CrossOrigin(origins = "*")
    public List<TransactionHistory> getAll(){
        return transactionHistoryService.findAll();
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @CrossOrigin(origins = "*")
    public @ResponseBody
    ResponseEntity<ProjectStatus> saveTopUpHistory(@Valid @RequestBody TransactionHistory history){
        String uniqueID = UUID.randomUUID().toString();
        history.setId(uniqueID);
        String id = history.getBalance_id();
        Optional<Balance> balance = balanceService.findById(id);

        if (balance.get().getId().equals(history.getBalance_id()) && balance.get().getBalance() > history.getTransaction_value()) {
            //cek FK di TransactionHistory = di PK Balance && Jumlah saldo > pengeluaran THEN transaksi dilakukan
            transactionHistoryService.save(history); //simpan transaksi di TransactionHistory
            balanceService.updateById(history.getBalance_id(),history.getTransaction_value()); //jumlah saldo setelah transaksi
            return new ResponseEntity<ProjectStatus>(new ProjectStatus("Success"), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<ProjectStatus>(new ProjectStatus("False"), HttpStatus.OK); //saldo tidak cukup
        }
    }

    @GetMapping(value = "/details/{id}")
    @CrossOrigin(origins = "*")
    public Optional<TransactionHistory> getById(@PathVariable(value = "id") String id){
        return transactionHistoryService.findById(id);
    }

    @PostMapping(value = "/delete/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<ProjectStatus> delete(@PathVariable(value = "id") TransactionHistory history){
        history.setStatus("Inactive");
        transactionHistoryService.save(history);
        return new ResponseEntity<ProjectStatus>(new ProjectStatus("Success"), HttpStatus.OK);
    }
}
