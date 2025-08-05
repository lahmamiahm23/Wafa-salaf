package com.example.wafaapp.controllers;

import com.example.wafaapp.dto.req.AccountReqDto;
import com.example.wafaapp.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/accounts")

@Valid
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<String> addAccount(@RequestBody @Valid AccountReqDto newAccount) {
        String response = accountService.addAccount(newAccount);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Optionnel : méthode fictive pour éviter erreurs de compilation
    @PutMapping("/{id}")
    public ResponseEntity<String> updateAccount(@PathVariable long id, @RequestBody AccountReqDto updateAccount) {
        accountService.updateAccount(id, updateAccount);
        return new ResponseEntity<>("Account updated (fake implementation)", HttpStatus.OK);
    }
}
