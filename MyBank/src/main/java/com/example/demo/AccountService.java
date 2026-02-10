package com.example.demo;


import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository repo;
    public AccountService(AccountRepository repo) { this.repo = repo; }

    public List<Account> getAllAccounts() { return repo.findAll(); }

    public Account createAccount(String name, double balance) {
        return repo.save(new Account(name, balance));
    }

    public Account deposit(Long id, double amount) {
        Account acc = repo.findById(id).orElseThrow();
        acc.setBalance(acc.getBalance() + amount);
        return repo.save(acc);
    }

    public Account withdraw(Long id, double amount) {
        Account acc = repo.findById(id).orElseThrow();
        if (acc.getBalance() < amount) throw new RuntimeException("Insufficient funds");
        acc.setBalance(acc.getBalance() - amount);
        return repo.save(acc);
    }
}
