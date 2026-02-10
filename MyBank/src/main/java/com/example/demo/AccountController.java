package com.example.demo;


import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
@CrossOrigin(origins = "*") // allow JS from local files
public class AccountController {
    private final AccountService service;
    public AccountController(AccountService service) { this.service = service; }

    @GetMapping
    public List<Account> getAll() { return service.getAllAccounts(); }

    @PostMapping("/create")
    public Account create(@RequestParam String name, @RequestParam double balance) {
        return service.createAccount(name, balance);
    }

    @PostMapping("/deposit")
    public Account deposit(@RequestParam Long id, @RequestParam double amount) {
        return service.deposit(id, amount);
    }

    @PostMapping("/withdraw")
    public Account withdraw(@RequestParam Long id, @RequestParam double amount) {
        return service.withdraw(id, amount);
    }
}
