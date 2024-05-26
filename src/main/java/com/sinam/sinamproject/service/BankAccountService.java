package com.sinam.sinamproject.service;


import com.sinam.sinamproject.entity.BankAccount;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BankAccountService {
    BankAccount addBankAccount(Long userId);
    List<BankAccount> getUserBankAccounts(Long userId);
    List<BankAccount> getActiveBankAccounts(Long userId);
    BankAccount activateBankAccount(Long accountId);
}
