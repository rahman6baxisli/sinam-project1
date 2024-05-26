package com.sinam.sinamproject.service.impl;

import com.sinam.sinamproject.entity.BankAccount;
import com.sinam.sinamproject.entity.Transfer;
import com.sinam.sinamproject.repository.BankAccountRepository;
import com.sinam.sinamproject.repository.TransferRepository;
import com.sinam.sinamproject.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
public class TransferServiceImpl implements TransferService {

    private final TransferRepository transferRepository;
    private final BankAccountRepository bankAccountRepository;

    @Override
    public Transfer transferMoney(Long senderAccountId, Long receiverAccountId, Double amount) {
        BankAccount senderAccount = bankAccountRepository.findById(senderAccountId)
                .orElseThrow(() -> new IllegalArgumentException("Sender account not found"));
        BankAccount receiverAccount = bankAccountRepository.findById(receiverAccountId)
                .orElseThrow(() -> new IllegalArgumentException("Receiver account not found"));

        if (!"ACTIVE".equals(senderAccount.getStatus()) || !"ACTIVE".equals(receiverAccount.getStatus())) {
            throw new IllegalArgumentException("Both accounts must be active");
        }

        if (senderAccount.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient funds");
        }

        senderAccount.setBalance(senderAccount.getBalance() - amount);
        receiverAccount.setBalance(receiverAccount.getBalance() + amount);

        Transfer transfer = new Transfer();
        transfer.setAmount(amount);
        transfer.setDate(new Date());
        transfer.setSenderAccount(senderAccount);
        transfer.setReceiverAccount(receiverAccount);

        bankAccountRepository.save(senderAccount);
        bankAccountRepository.save(receiverAccount);
        return transferRepository.save(transfer);
    }

    @Override
    public List<Transfer> getUserTransfers(Long userId) {
        return transferRepository.findBySenderAccountId(userId);
    }
}
