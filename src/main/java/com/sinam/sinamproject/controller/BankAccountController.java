package com.sinam.sinamproject.controller;

import com.sinam.sinamproject.entity.BankAccount;
import com.sinam.sinamproject.service.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/bankAccount")
@RequiredArgsConstructor
public class BankAccountController {

    private final BankAccountService bankAccountService;

    @PostMapping("/{userId}")
    public ResponseEntity<BankAccount> addBankAccount(@PathVariable Long userId) {
        return ResponseEntity.ok(bankAccountService.addBankAccount(userId));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<BankAccount>> getUserBankAccounts(@PathVariable Long userId) {
        return ResponseEntity.ok(bankAccountService.getUserBankAccounts(userId));
    }

    @GetMapping("/active/{userId}")
    public ResponseEntity<List<BankAccount>> getActiveBankAccounts(@PathVariable Long userId) {
        return ResponseEntity.ok(bankAccountService.getActiveBankAccounts(userId));
    }

    @PutMapping("/activate/{accountId}")
    public ResponseEntity<BankAccount> activateBankAccount(@PathVariable Long accountId) {
        return ResponseEntity.ok(bankAccountService.activateBankAccount(accountId));
    }
}
