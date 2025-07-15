package com.cognizant.account;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("/accounts/{number}")
    public Account getAccount(@PathVariable String number) {
        // Return dummy account details
        return new Account(number, "savings", 234343);
    }
}


class Account {
    public String number;
    public String type;
    public int balance;

    public Account(String number, String type, int balance) {
        this.number = number;
        this.type = type;
        this.balance = balance;
    }
}
