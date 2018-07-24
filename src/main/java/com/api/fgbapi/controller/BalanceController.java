package com.api.fgbapi.controller;

import com.api.fgbapi.misc.ProjectStatus;
import com.api.fgbapi.model.Balance;
import com.api.fgbapi.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/balance", method = RequestMethod.GET)
public class BalanceController {

    @Autowired
    BalanceService balanceService;

    @GetMapping("/helo")
    public @ResponseBody
    String TesterHello() {
        return "HELLO WORLD";

    }

    @PutMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    ResponseEntity<ProjectStatus> saveBalance(@Valid @RequestBody Balance user) {
        String uniqueID = UUID.randomUUID().toString();
        user.setId(uniqueID);
        balanceService.save(user);
        return new ResponseEntity<ProjectStatus>(new ProjectStatus("Success..."), HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public List<Balance> getAll() {
        return balanceService.findAll();
    }

    @GetMapping(value = "/details/{id}")
    public Optional<Balance> getBalanceById(@PathVariable(value = "id") String id) {
        return balanceService.findById(id);
    }
}
