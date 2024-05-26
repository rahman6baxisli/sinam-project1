package com.sinam.sinamproject.service.impl;

import com.sinam.sinamproject.entity.BankAccount;
import com.sinam.sinamproject.entity.User;
import com.sinam.sinamproject.repository.BankAccountRepository;
import com.sinam.sinamproject.repository.UserRepository;
import com.sinam.sinamproject.service.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {

    private final BankAccountRepository bankAccountRepository;
    private final UserRepository userRepository;

    @Override
    public BankAccount addBankAccount(Long userId) {
        User user = (User) userRepository.findById(Math.toIntExact(userId)).orElseThrow(() -> new IllegalArgumentException("User not found"));
        BankAccount bankAccount = new BankAccount();
        bankAccount.setUser(user);
        return bankAccountRepository.save(bankAccount);
    }

    @Override
    public List<BankAccount> getUserBankAccounts(Long userId) {
        return bankAccountRepository.findByUserId(userId);
    }

    @Override
    public List<BankAccount> getActiveBankAccounts(Long userId) {
        return bankAccountRepository.findByStatusAndUserId("ACTIVE", userId);
    }

    @Override
    public BankAccount activateBankAccount(Long accountId) {
        BankAccount bankAccount = bankAccountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Bank account not found"));
        bankAccount.setStatus("ACTIVE");
        return bankAccountRepository.save(bankAccount);
    }
}
