package com.api.fgbapi.controller;

import com.api.fgbapi.misc.ProjectStatus;
import com.api.fgbapi.model.Account;
import com.api.fgbapi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(path="/users", method = GET)
public class AccountController {
    private String hashPassword(String plainTextPassword){
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    private int checkPass(String plainPassword, String hashedPassword) {
        if (BCrypt.checkpw(plainPassword, hashedPassword))
            return 1;
        else
            return 0;
    }

    @Autowired
    private AccountService accountService;

    @PostMapping("/tester")
    public @ResponseBody
    ResponseEntity<ProjectStatus> Tester(){
        return new ResponseEntity<ProjectStatus>(new ProjectStatus("Success..."), HttpStatus.OK);

    }

    @GetMapping("/helo")
    public @ResponseBody
    String TesterHello(){
        return "HELLO WORLD";

    }

    @PostMapping("/registerdemo")
    public @ResponseBody
    String registNewAccountDemo(@Valid @RequestBody Account account){
        accountService.save(account);
        return "saved";
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/registerlive")
    public @ResponseBody
    ResponseEntity<ProjectStatus> registNewAccountLive(@Valid @RequestBody Account account){
        account.setPassword(hashPassword(account.getPassword()));
        account.setId("1");
        account.setLive(true);
        System.out.println(account.getAcc_owner());
        accountService.save(account);
        return new ResponseEntity<ProjectStatus>(new ProjectStatus("Success..."), HttpStatus.OK);
    }

    @PostMapping("/loginlive")
    @CrossOrigin(origins = "*")
    public @ResponseBody ResponseEntity<ProjectStatus> loginAccountLive(@Valid @RequestBody Account account){
        System.out.println(account);
        accountService.findById(account.getId());
        return new ResponseEntity<ProjectStatus>(new ProjectStatus("Success..."), HttpStatus.OK);
    }

    @GetMapping("/listacc")
    @CrossOrigin(origins = "*")
    public @ResponseBody
    List<Account> showListAccDemo(){
        return accountService.findAll();
    }

    @GetMapping("/details/{id}")
    @CrossOrigin(origins = "*")
    public Optional<Account> getAccById(@PathVariable(value = "id") String id) {
        return accountService.findById(id);
    }

    @GetMapping("/update/{id}")
    @CrossOrigin(origins = "*")
    public  @ResponseBody ResponseEntity<ProjectStatus> updateAccById(@PathVariable(value = "id") String id) {
        Account accToUpdate = accountService.updateById(id);
        accToUpdate.setFirst_name(id);
        return new ResponseEntity<ProjectStatus>(new ProjectStatus("Success..."), HttpStatus.OK);
    }
}
