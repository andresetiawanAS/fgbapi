package com.api.fgbapi.controller;

import com.api.fgbapi.misc.ProjectStatus;
import com.api.fgbapi.model.Account;
import com.api.fgbapi.model.Balance;
import com.api.fgbapi.service.AccountService;
import com.api.fgbapi.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(path = "/users", method = GET)
public class AccountController {
    private String hashPassword(String plainTextPassword) {
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
    @Autowired
    private BalanceService balanceService;

    @PostMapping("/tester")
    public @ResponseBody
    ResponseEntity<ProjectStatus> Tester() {
        return new ResponseEntity<ProjectStatus>(new ProjectStatus("Success..."), HttpStatus.OK);

    }

    @GetMapping("/helo")
    public @ResponseBody
    String TesterHello() {
        return "HELLO WORLD";

    }

    @PostMapping("/registerdemo")
    public @ResponseBody
    String registNewAccountDemo(@Valid @RequestBody Account account) {
        accountService.save(account);
        return "saved";
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/registerlive")
    @Transactional
    public @ResponseBody
    ResponseEntity<ProjectStatus> registNewAccountLive(@Valid @RequestBody Account account) {
        account.setPassword(hashPassword(account.getPassword()));
        String id = UUID.randomUUID().toString();
        account.setId(id);
        account.setLive(true);

        Balance balance = new Balance();
        String balanceId = UUID.randomUUID().toString();
        balance.setId(balanceId);
        balance.setBalance(0D);
        balance.setAccount(account);

        accountService.save(account);
        balanceService.save(balance);
        return new ResponseEntity<ProjectStatus>(new ProjectStatus("Success..."), HttpStatus.OK);
    }

    @PostMapping("/loginlive")
    @CrossOrigin(origins = "*")
    public @ResponseBody
    ResponseEntity<ProjectStatus> loginAccountLive(@Valid @RequestBody Account account) {
        Optional<Account> user = accountService.findByEmail(account.getEmail());
//        user.orElseThrow(()-> new UsernameNotFoundException("Email not found!"));
        System.out.println(user);

        try {
            if (user.get().getEmail().equals(account.getEmail())) {

                int checkPassword = checkPass(account.getPassword(), user.get().getPassword());

                if (checkPassword == 1) {
                    return new ResponseEntity<ProjectStatus>(new ProjectStatus("Success..."), HttpStatus.OK);
                } else {
                    return new ResponseEntity<ProjectStatus>(new ProjectStatus("Wrong password..."), HttpStatus.OK);
                }
            }
        } catch (NoSuchElementException exception) {
            System.out.println("What is this?");

            return new ResponseEntity<ProjectStatus>(new ProjectStatus("Email not found..."), HttpStatus.OK);
        }
        return null;

    }

    @GetMapping("/listacc")
    @CrossOrigin(origins = "*")
    public @ResponseBody
    List<Account> showListAccDemo() {
        return accountService.findAll();
    }

    @GetMapping("/details/{id}")
    @CrossOrigin(origins = "*")
    public Optional<Account> getAccById(@PathVariable(value = "id") String id) {
        return accountService.findById(id);
    }

    @GetMapping("/update/{id}")
    @CrossOrigin(origins = "*")
    public @ResponseBody
    ResponseEntity<ProjectStatus> updateAccById(@PathVariable(value = "id") String id) {
        Account accToUpdate = accountService.updateById(id);
        accToUpdate.setFirst_name(id);
        return new ResponseEntity<ProjectStatus>(new ProjectStatus("Success..."), HttpStatus.OK);
    }
}
